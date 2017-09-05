package algo.graphbased;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

public class TestShortestPathDijkstra {
    Graph<Graph.Node<String>> unweightedGraph = new Graph<>();
    Graph<Graph.Node<String>> weightedGraph = new Graph<>();
    Graph.Node a = new Graph.Node<>("a");
    Graph.Node b = new Graph.Node<>("b");
    Graph.Node c = new Graph.Node<>("c");
    Graph.Node d = new Graph.Node<>("d");
    Graph.Node e = new Graph.Node<>("e");
    Graph.Node f = new Graph.Node<>("f");
    Graph.Node g = new Graph.Node<>("g");
    Graph.Node h = new Graph.Node<>("h");
    Graph.Node i = new Graph.Node<>("i");
    Graph.Node j = new Graph.Node<>("j");
    Graph.Node k = new Graph.Node<>("k");
    Graph.Node l = new Graph.Node<>("l");

    @Before
    public void before() {

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

        //increased distance from a-c and c-g
        weightedGraph.nodesAndEdges.put(a, Lists.newArrayList(Pair.of(b, 3), Pair.of(c, 5)));
        weightedGraph.nodesAndEdges.put(b, Lists.newArrayList(Pair.of(l, 1), Pair.of(d, 1), Pair.of(e, 6), Pair.of(a, 1)));
        weightedGraph.nodesAndEdges.put(c, Lists.newArrayList(Pair.of(a, 1), Pair.of(e, 4), Pair.of(g, 2)));
        weightedGraph.nodesAndEdges.put(d, Lists.newArrayList(Pair.of(b, 1), Pair.of(i, 1), Pair.of(j, 1)));
        weightedGraph.nodesAndEdges.put(e, Lists.newArrayList(Pair.of(b, 1), Pair.of(c, 1), Pair.of(f, 1), Pair.of(h, 1), Pair.of(g, 1)));
        weightedGraph.nodesAndEdges.put(f, Lists.newArrayList(Pair.of(e, 1), Pair.of(k, 1)));
        weightedGraph.nodesAndEdges.put(g, Lists.newArrayList(Pair.of(e, 1), Pair.of(c, 1)));
        weightedGraph.nodesAndEdges.put(h, Lists.newArrayList(Pair.of(e, 1)));
        weightedGraph.nodesAndEdges.put(i, Lists.newArrayList(Pair.of(d, 1)));
        weightedGraph.nodesAndEdges.put(j, Lists.newArrayList(Pair.of(d, 1)));
        weightedGraph.nodesAndEdges.put(k, Lists.newArrayList(Pair.of(f, 1)));
        weightedGraph.nodesAndEdges.put(l, Lists.newArrayList(Pair.of(b, 1)));
    }

    @Test
    public void testShortestPath_UnweightedGraph() {

        ShortestPathDijkstra shortestPathDijkstra = new ShortestPathDijkstra(unweightedGraph);
        shortestPathDijkstra.calculateShortestPath(a);
//        System.out.println(shortestPathDijkstra.nodeDistanceFromSource);
//        System.out.println(shortestPathDijkstra.nodeToPredecessor);
        System.out.println("shortest path from a to k when graph is unweighted: " + shortestPathDijkstra.getShortestPath(k));
        System.out.println("shortest path from a to g when graph is unweighted: " + shortestPathDijkstra.getShortestPath(g));
    }

    @Test
    public void testShortestPath_WeightedGraph() {

        ShortestPathDijkstra shortestPathDijkstra = new ShortestPathDijkstra(weightedGraph);
        shortestPathDijkstra.calculateShortestPath(a);
//        System.out.println(shortestPathDijkstra.nodeDistanceFromSource);
//        System.out.println(shortestPathDijkstra.nodeToPredecessor);
        System.out.println("shortest path from a to k when graph is weighted: " + shortestPathDijkstra.getShortestPath(k));
        System.out.println("shortest path from a to g when graph is weighted: " + shortestPathDijkstra.getShortestPath(g));
    }

}
