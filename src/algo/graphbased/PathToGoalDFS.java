package algo.graphbased;

import java.util.HashSet;
import java.util.Set;

import algo.graphbased.Graph.Node;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Technique shows how to return path to a goal.
 *
 */
public class PathToGoalDFS {

    public static String pathToGoal(Graph<Node<Character>> g, Node<Character> start, Node<Character> end) {
        Set<Node<Character>> visited = new HashSet<>();
        return pathToGoal(g, start, end, visited, "");
    }

    private static String pathToGoal(Graph<Node<Character>> g, Node<Character> start, Node<Character> end,
                                     Set<Node<Character>> visited, String pathSoFar) {

        if (visited.contains(start)) {
            return null;
        }

        if(start == end) {
            return pathSoFar + start.data;
        }

        visited.add(start);
        for (Pair<Node<Character>, Integer> adjpair : g.getAdjacents(start)) {
            Node<Character> adj = adjpair.getLeft();
            String pathToGoal = pathToGoal(g, adj, end, visited, pathSoFar + start.data);
            if (pathToGoal != null) {
                return pathToGoal;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Graph<Node<Character>> unweightedGraph = new Graph<>();
        Node<Character> a = new Node<>('a');
        Node<Character> b = new Node<>('b');
        Node<Character> c = new Node<>('c');
        Node<Character> d = new Node<>('d');
        Node<Character> e = new Node<>('e');
        Node<Character> f = new Node<>('f');
        Node<Character> g = new Node<>('g');
        Node<Character> h = new Node<>('h');
        Node<Character> i = new Node<>('i');
        Node<Character> j = new Node<>('j');
        Node<Character> k = new Node<>('k');
        Node<Character> l = new Node<>('l');

        unweightedGraph.nodesAndEdges.put(a, Lists.newArrayList(Pair.of(b, 1), Pair.of(c, 1)));
        unweightedGraph.nodesAndEdges.put(b, Lists.newArrayList(Pair.of(l, 1), Pair.of(d, 1), Pair.of(e, 1), Pair.of(a, 1)));
        unweightedGraph.nodesAndEdges.put(c, Lists.newArrayList(Pair.of(a, 1), Pair.of(e, 1), Pair.of(g, 1)));
        unweightedGraph.nodesAndEdges.put(d, Lists.newArrayList(Pair.of(b, 1), Pair.of(i, 1), Pair.of(j, 1)));
        unweightedGraph.nodesAndEdges.put(e, Lists.newArrayList(Pair.of(b, 1), Pair.of(c, 1), Pair.of(f, 1), Pair.of(h, 1), Pair.of(g, 1)));
        unweightedGraph.nodesAndEdges.put(f, Lists.newArrayList(Pair.of(e, 1), Pair.of(k, 1)));
        unweightedGraph.nodesAndEdges.put(g, Lists.newArrayList(Pair.of(e, 1), Pair.of(c, 1)));
        unweightedGraph.nodesAndEdges.put(h, Lists.newArrayList(Pair.of(e, 1)));
        unweightedGraph.nodesAndEdges.put(i, Lists.newArrayList(Pair.of(d, 1)));
        unweightedGraph.nodesAndEdges.put(j, Lists.newArrayList(Pair.of(d, 1)));
        unweightedGraph.nodesAndEdges.put(k, Lists.newArrayList(Pair.of(f, 1)));
        unweightedGraph.nodesAndEdges.put(l, Lists.newArrayList(Pair.of(b, 1)));

        System.out.println(PathToGoalDFS.pathToGoal(unweightedGraph, a, c));
    }
}
