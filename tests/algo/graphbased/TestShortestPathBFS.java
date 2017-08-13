package algo.graphbased;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestShortestPathBFS {

    @Test
    public void testShortestPath_joint_graph() {
        Graph.Node foul = new Graph.Node<>("foul");
        Graph.Node foil = new Graph.Node<>("foil");
        Graph.Node fail = new Graph.Node<>("fail");
        Graph.Node fall = new Graph.Node<>("fall");
        Graph.Node pail = new Graph.Node<>("pail");
        Graph.Node poll = new Graph.Node<>("poll");
        Graph.Node pool = new Graph.Node<>("pool");
        Graph.Node cool = new Graph.Node<>("cool");
        Graph.Node fool = new Graph.Node<>("fool");
        Graph.Node pope = new Graph.Node<>("pope");
        Graph.Node pale = new Graph.Node<>("pale");
        Graph.Node sale = new Graph.Node<>("sale");
        Graph.Node sage = new Graph.Node<>("sage");
        Graph.Node page = new Graph.Node<>("page");

        Graph<Graph.Node<String>> g = new Graph<>();
        g.nodesAndEdges.put(foul, Lists.newArrayList(fool, foil));
        g.nodesAndEdges.put(foil, Lists.newArrayList(foul, fail, fool));
        g.nodesAndEdges.put(fail, Lists.newArrayList(foil, fall));
        g.nodesAndEdges.put(fall, Lists.newArrayList(fail, pail));
        g.nodesAndEdges.put(pail, Lists.newArrayList(poll, pale));
        g.nodesAndEdges.put(poll, Lists.newArrayList(pail, poll, pool));
        g.nodesAndEdges.put(pool, Lists.newArrayList(poll, cool, fool));
        g.nodesAndEdges.put(cool, Lists.newArrayList(fool, pool));
        g.nodesAndEdges.put(fool, Lists.newArrayList(cool, pool, foul, foil));
        g.nodesAndEdges.put(pope, Lists.newArrayList(pool));
        g.nodesAndEdges.put(pale, Lists.newArrayList(sale, page));
        g.nodesAndEdges.put(sale, Lists.newArrayList(pale, sage));
        g.nodesAndEdges.put(sage, Lists.newArrayList(page, sale));
        g.nodesAndEdges.put(page, Lists.newArrayList(pale, sage));

        ShortestPathBFS<Graph.Node<String>> shortestPath = new ShortestPathBFS(g);

        shortestPath.processGraphFromANode(new Graph.Node("fool"));

        assertThat(shortestPath.shortestPath(new Graph.Node("fool"), new Graph.Node("sage")),
                contains(fool, foil, fail, fall, pail, pale, page, sage));
    }

    @Test
    public void testShortestPath_disjoint_graph() {
        Graph.Node foul = new Graph.Node<>("foul");
        Graph.Node foil = new Graph.Node<>("foil");
        Graph.Node fail = new Graph.Node<>("fail");
        Graph.Node fall = new Graph.Node<>("fall");
        Graph.Node pail = new Graph.Node<>("pail");
        Graph.Node poll = new Graph.Node<>("poll");
        Graph.Node pool = new Graph.Node<>("pool");
        Graph.Node cool = new Graph.Node<>("cool");

        Graph<Graph.Node<String>> g = new Graph<>();
        g.nodesAndEdges.put(foul, Lists.newArrayList(fall, foil));
        g.nodesAndEdges.put(foil, Lists.newArrayList(foul, fail));
        g.nodesAndEdges.put(fail, Lists.newArrayList(foil, fall));
        g.nodesAndEdges.put(fall, Lists.newArrayList(fail, foul));
        g.nodesAndEdges.put(pail, Lists.newArrayList(poll, cool));
        g.nodesAndEdges.put(poll, Lists.newArrayList(pail, pool));
        g.nodesAndEdges.put(pool, Lists.newArrayList(poll, cool));
        g.nodesAndEdges.put(cool, Lists.newArrayList(pail, pool));

        ShortestPathBFS<Graph.Node<String>> shortestPath = new ShortestPathBFS(g);

        shortestPath.processGraphFromANode(new Graph.Node("foul"));

        assertEquals(Lists.newArrayList(),
                shortestPath.shortestPath(new Graph.Node("foul"), new Graph.Node("pail")));
    }
}
