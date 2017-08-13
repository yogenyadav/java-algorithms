package algo.graphbased;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Transform a word into another word by changing just one letter at a time.
 * Example FOOL to SAGE transformation
 * FOOL->POOL->POLL->POLE->PALE->SALE->SAGE
 *
 */
public class ShortestPathBFS<T> {

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
    private final Graph<Graph.Node<T>> graph;

    public ShortestPathBFS(Graph<Graph.Node<T>> graph) {
        this.graph = graph;
    }

    /**
     * This method processes graph for a given node. The method builds shortest path from given node to
     * all the other nodes in the graph. A path always exists if nodes are connected via at least one path.
     * Path does not exist or disjoint graph.
     *
     */
    public void processGraphFromANode(Graph.Node<T> node) {
        Graph.Node<T> start = this.graph.getNode(node);
        start.distance = 0;
        start.predecessor = null;
        Queue<Graph.Node<T>> q = Queues.newLinkedBlockingDeque();
        q.offer(start);
        while (!q.isEmpty()) {
            Graph.Node parent = q.poll();
            Set<Graph.Node> adjacents = this.graph.getAdjacents(parent);
            for (Graph.Node adjacent : adjacents) {
                if (!adjacent.visited) {
                    adjacent.predecessor = parent;
                    adjacent.distance = parent.distance + 1;
                    q.offer(adjacent);
                }
            }
            parent.visited = true;
        }
    }

    public List<Graph.Node> shortestPath(Graph.Node from, Graph.Node to) {
        Stack<Graph.Node> path = new Stack<>();
        Graph.Node src = this.graph.getNode(from);
        Graph.Node dest = this.graph.getNode(to);
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

    public List<Graph.Node> stackToList(Stack<Graph.Node> stack) {
        List<Graph.Node> l = Lists.newArrayList();
        while (!stack.empty()) {
            l.add(stack.pop());
        }
        return l;
    }
}
