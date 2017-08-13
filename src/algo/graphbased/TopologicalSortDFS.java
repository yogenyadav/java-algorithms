package algo.graphbased;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * A topological ordering is possible if and only if the graph has no directed cycles, that is, if it is a
 * directed acyclic graph (DAG). Any DAG has at least one topological ordering, and algorithms are known
 * for constructing a topological ordering of any DAG in linear time.
 * Applications:
 * 1. Build systems determine order of building packages
 * 2. apt-get uses to determine order of pkg installations
 * 3. maven build resolution
 *
 * Algorithm:
 * For each node in a DAG
 * 1. Recursively apply DFS
 * 2. When node's all adjacents are explored, add node to a stack.
 * Order of nodes in stack is the topological sort order of nodes
 */

public class TopologicalSortDFS {

    public static List<Integer> topologicalSort(Graph<Integer> g) {
        Set<Integer> visitedNodes = Sets.newHashSet();
        Stack<Integer> stack = new Stack<>();

        Set<Integer> nodes = g.getNodes();
        for (int node : nodes) {
            if (!visitedNodes.contains(node)) {
                topologicalSort(g, node, visitedNodes, stack);
            }
        }
        List<Integer> topOrderList = new ArrayList<>();
        while (!stack.empty()) {
            topOrderList.add(stack.pop());
        }
        return topOrderList;
    }

    private static void topologicalSort(Graph<Integer> g, int node, Set<Integer> visitedNodes, Stack<Integer> stack) {
        visitedNodes.add(node);
        Set<Integer> childNodes = g.getAdjacents(node);
        for (int childNode : childNodes) {
            if (!visitedNodes.contains(childNode)) {
                visitedNodes.add(childNode);
                topologicalSort(g, childNode, visitedNodes, stack);
            }
        }
        stack.push(node);
    }
}
