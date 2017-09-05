package algo.graphbased;

import algo.graphbased.Graph.Node;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Algorithm:
 * In order to retrieve the shortest path from the origin to a node, you need to maintain two items for each node in the graph:
 * 1. its current shortest distance
 * 2. the preceding node in the shortest path.
 *
 * Define nodeToPredecessor and nodeDistanceFromSource
 * Initialize nodeToPredecessor to null predecessor for all nodes
 * Initialize nodeDistanceFromSource to infinite for all nodes and 0 for src node.
 *
 * Iterate thru the nodes until all nodes are done
 * 1. in each iteration find node n with minimum distance to src from nodeDistanceFromSource
 *    for each adjacent of n
 *       if adjacent's current distance from src (with its current predecessor) >
 *           adjacent's distance from src if n is predecessor
 *            Update n as adjacent's predecessor -> nodeToPredecessor
 *            Update adjacent's distance to source with n as adjacent -> nodeDistanceFromSource
 *
 * Now nodeToPredecessor contains shortest distance to src from each node in graph.
 *
 */
public class ShortestPathDijkstra {

    Map<Node, Node> nodeToPredecessor = new HashMap<>();
    Map<Node, Integer> nodeDistanceFromSource = new HashMap<>();

    Graph<Node<String>> graph;

    public ShortestPathDijkstra(Graph<Node<String>> graph) {
        this.graph = graph;
    }

    public void calculateShortestPath(Node src) {

        Set<Node<String>> nodes = this.graph.getNodes();

        for(Node n : nodes) {
            nodeToPredecessor.put(n, null);
            nodeDistanceFromSource.put(n, Integer.MAX_VALUE);
        }
        nodeDistanceFromSource.put(src, 0);

        while (!nodes.isEmpty()) {
            Node nodeWithMinimumDist = nodeWithMinimumDist(nodes);

            nodes.remove(nodeWithMinimumDist);

            Set<Pair<Node, Integer>> adjs = (Set<Pair<Node, Integer>>) this.graph.getAdjacents(nodeWithMinimumDist);

            for (Pair<Node, Integer> adj : adjs) {

                int currentDistanceFromSource = nodeDistanceFromSource.get(adj.getLeft()); //infinite

                int distanceFromSourceWithNewPredecessor =
                        adj.getRight() + nodeDistanceFromSource.get(nodeWithMinimumDist); //1

                if (distanceFromSourceWithNewPredecessor < currentDistanceFromSource) {
                    nodeToPredecessor.put(adj.getLeft(), nodeWithMinimumDist);
                    nodeDistanceFromSource.put(adj.getLeft(), distanceFromSourceWithNewPredecessor);
                }
            }
        }
    }

    private Node nodeWithMinimumDist(Set<Node<String>> nodes) {
        Node n = null;
        int dist = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> e : nodeDistanceFromSource.entrySet()) {
            int d = e.getValue();
            if (d < dist && nodes.contains(e.getKey())) {
                n = e.getKey();
            }
        }
        return n;
    }

    public List<Node> getShortestPath(Node toDestNode) {
        List<Node> l = new ArrayList<>();
        Node n = toDestNode;
        while (nodeToPredecessor.get(n) != null) {
            l.add(n);
            n = nodeToPredecessor.get(n);
        }
        l.add(n);
        return l;
    }
}
