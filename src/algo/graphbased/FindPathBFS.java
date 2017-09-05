package algo.graphbased;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import algo.graphbased.Graph.Node;

/**
 * Transform a word into another word by changing just one letter at a time.
 * Example FOOL to SAGE transformation
 * FOOL->POOL->POLL->POLE->PALE->SALE->SAGE
 *
 * O(V+E)
 *
 */
public class FindPathBFS<T> {

    /**
     * BFS implementation
     * 1. Starts from a given node, marks its distance as 0 and its predecessor as null.
     * 2. Updates predecessors for every other node that can be reached from given node.
     * 3. Also updates distance of every other node that can be reached from given node.
     *
     * Now graph is ready to provide shortest path.
     *
     * BSF algorithm builds a breadth first search tree; tree is bottom up tree i.e. child node links to its
     * predecessor node (instead of traditional trees where root nodes link to child nodes).
     *
     */
    private final Graph<Node<T>> graph;

    public FindPathBFS(Graph<Node<T>> graph) {
        this.graph = graph;
    }

    /**
     * This method processes graph for a given node. The method builds path from given node to all the other
     * nodes in the graph. A path always exists if nodes are connected via at least one path, path does not exist for 
     * disjoint graph.
     *
     */
    public void updatesDistancesToAllOtherNodes(Node<T> node) {
        Node<T> start = this.graph.getNode(node);
        start.distance = 0;
        start.predecessor = null;
        Queue<Node<T>> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Node parent = q.poll();
            Set<Pair<Node, Integer>> adjacents = this.graph.getAdjacents(parent);
            for (Pair<Node, Integer> adjacent : adjacents) {
                if (!adjacent.getLeft().visited) {
                    adjacent.getLeft().predecessor = parent;
                    adjacent.getLeft().distance = parent.distance + 1;
                    q.offer(adjacent.getLeft());
                }
            }
            parent.visited = true;
        }
    }

    public List<Node> findPath(Node from, Node to) {
        Stack<Node> path = new Stack<>();
        Node src = this.graph.getNode(from);
        Node dest = this.graph.getNode(to);
        path.push(dest);

        if (dest.predecessor == null) {
            // dest is not connected to src in any way, its a disjoint graph.
            return Lists.newArrayList();
        }

        while(dest.predecessor != null && !dest.predecessor.equals(src)) {
            dest = dest.predecessor;
            path.push(dest);
        }
        path.push(src);
        return stackToList(path);
    }

    public boolean pathExists(Node start, Node end){
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Node n = q.poll();
            Set<Pair<Node, Integer>> adjacents = this.graph.getAdjacents(n);
            for(Pair<Node, Integer> adj : adjacents) {
                if (!adj.getLeft().visited) {
                    if (adj.getLeft().equals(end)) {
                        return true;
                    } else {
                        adj.getLeft().visited = true;
                        q.add(adj.getLeft());
                    }
                }
            }
        }
        return false;
    }

    private List<Node> stackToList(Stack<Node> stack) {
        List<Node> l = Lists.newArrayList();
        while (!stack.empty()) {
            l.add(stack.pop());
        }
        return l;
    }
}
