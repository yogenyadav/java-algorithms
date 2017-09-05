package algo.graphbased;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestFindPathBFS {

    @Test
    public void testPath_joint_graph() {
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
        g.nodesAndEdges.put(foul, Lists.newArrayList(Pair.of(fool, 1), Pair.of(foil, 1)));
        g.nodesAndEdges.put(foil, Lists.newArrayList(Pair.of(foul, 1), Pair.of(fail, 1), Pair.of(fool, 1)));
        g.nodesAndEdges.put(fail, Lists.newArrayList(Pair.of(foil, 1), Pair.of(fall, 1)));
        g.nodesAndEdges.put(fall, Lists.newArrayList(Pair.of(fail, 1), Pair.of(pail, 1)));
        g.nodesAndEdges.put(pail, Lists.newArrayList(Pair.of(poll, 1), Pair.of(pale, 1)));
        g.nodesAndEdges.put(poll, Lists.newArrayList(Pair.of(pail, 1), Pair.of(poll, 1), Pair.of(pool, 1)));
        g.nodesAndEdges.put(pool, Lists.newArrayList(Pair.of(poll, 1), Pair.of(cool, 1), Pair.of(fool, 1)));
        g.nodesAndEdges.put(cool, Lists.newArrayList(Pair.of(fool, 1), Pair.of(pool, 1)));
        g.nodesAndEdges.put(fool, Lists.newArrayList(Pair.of(cool, 1), Pair.of(pool, 1), Pair.of(foul, 1), Pair.of(foil, 1)));
        g.nodesAndEdges.put(pope, Lists.newArrayList(Pair.of(pool, 1)));
        g.nodesAndEdges.put(pale, Lists.newArrayList(Pair.of(sale, 1), Pair.of(page, 1)));
        g.nodesAndEdges.put(sale, Lists.newArrayList(Pair.of(pale, 1), Pair.of(sage, 1)));
        g.nodesAndEdges.put(sage, Lists.newArrayList(Pair.of(page, 1), Pair.of(sale, 1)));
        g.nodesAndEdges.put(page, Lists.newArrayList(Pair.of(pale, 1), Pair.of(sage, 1)));

        FindPathBFS<Graph.Node<String>> findPathBFS = new FindPathBFS(g);

        findPathBFS.updatesDistancesToAllOtherNodes(new Graph.Node("fool"));

        assertThat(findPathBFS.findPath(new Graph.Node("fool"), new Graph.Node("sage")),
                contains(fool, foil, fail, fall, pail, pale, page, sage));
    }

    @Test
    public void testPath_disjoint_graph() {
        Graph.Node foul = new Graph.Node<>("foul");
        Graph.Node foil = new Graph.Node<>("foil");
        Graph.Node fail = new Graph.Node<>("fail");
        Graph.Node fall = new Graph.Node<>("fall");
        Graph.Node pail = new Graph.Node<>("pail");
        Graph.Node poll = new Graph.Node<>("poll");
        Graph.Node pool = new Graph.Node<>("pool");
        Graph.Node cool = new Graph.Node<>("cool");

        Graph<Graph.Node<String>> g = new Graph<>();
        g.nodesAndEdges.put(foul, Lists.newArrayList(Pair.of(fall, 1), Pair.of(foil, 1)));
        g.nodesAndEdges.put(foil, Lists.newArrayList(Pair.of(foul,1), Pair.of(fail, 1)));
        g.nodesAndEdges.put(fail, Lists.newArrayList(Pair.of(foil,1), Pair.of(fall, 1)));
        g.nodesAndEdges.put(fall, Lists.newArrayList(Pair.of(fail,1), Pair.of(foul,1)));
        g.nodesAndEdges.put(pail, Lists.newArrayList(Pair.of(poll,1), Pair.of(cool,1)));
        g.nodesAndEdges.put(poll, Lists.newArrayList(Pair.of(pail,1), Pair.of(pool,1)));
        g.nodesAndEdges.put(pool, Lists.newArrayList(Pair.of(poll,1), Pair.of(cool,1)));
        g.nodesAndEdges.put(cool, Lists.newArrayList(Pair.of(pail,1), Pair.of(pool,1)));

        FindPathBFS<Graph.Node<String>> findPathBFS = new FindPathBFS(g);

        findPathBFS.updatesDistancesToAllOtherNodes(new Graph.Node("foul"));

        assertEquals(Lists.newArrayList(),
                findPathBFS.findPath(new Graph.Node("foul"), new Graph.Node("pail")));
    }

    @Test
    public void testPathExists() {
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
        g.nodesAndEdges.put(foul, Lists.newArrayList(Pair.of(fool, 1), Pair.of(foil, 1)));
        g.nodesAndEdges.put(foil, Lists.newArrayList(Pair.of(foul, 1), Pair.of(fail, 1), Pair.of(fool, 1)));
        g.nodesAndEdges.put(fail, Lists.newArrayList(Pair.of(foil, 1), Pair.of(fall, 1)));
        g.nodesAndEdges.put(fall, Lists.newArrayList(Pair.of(fail, 1), Pair.of(pail, 1)));
        g.nodesAndEdges.put(pail, Lists.newArrayList(Pair.of(poll, 1), Pair.of(pale, 1)));
        g.nodesAndEdges.put(poll, Lists.newArrayList(Pair.of(pail, 1), Pair.of(poll, 1), Pair.of(pool, 1)));
        g.nodesAndEdges.put(pool, Lists.newArrayList(Pair.of(poll, 1), Pair.of(cool, 1), Pair.of(fool, 1)));
        g.nodesAndEdges.put(cool, Lists.newArrayList(Pair.of(fool, 1), Pair.of(pool, 1)));
        g.nodesAndEdges.put(fool, Lists.newArrayList(Pair.of(cool, 1), Pair.of(pool, 1), Pair.of(foul, 1), Pair.of(foil, 1)));
        g.nodesAndEdges.put(pope, Lists.newArrayList(Pair.of(pool, 1)));
        g.nodesAndEdges.put(pale, Lists.newArrayList(Pair.of(sale, 1), Pair.of(page, 1)));
        g.nodesAndEdges.put(sale, Lists.newArrayList(Pair.of(pale, 1), Pair.of(sage, 1)));
        g.nodesAndEdges.put(sage, Lists.newArrayList(Pair.of(page, 1), Pair.of(sale, 1)));
        g.nodesAndEdges.put(page, Lists.newArrayList(Pair.of(pale, 1), Pair.of(sage, 1)));

        FindPathBFS<Graph.Node<String>> findPathBFS = new FindPathBFS(g);

        assertTrue(findPathBFS.pathExists(fool, sage));
    }
}
