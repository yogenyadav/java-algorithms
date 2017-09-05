package algo.graphbased;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDetectCycleUndirectedGraphDFS {
    @Test
    public void testIsGraphCyclic_has_cycle() {
        Graph<Integer> g = new Graph<>();
        g.nodesAndEdges.put(1, Lists.newArrayList(Pair.of(2,1), Pair.of(4,1)));
        g.nodesAndEdges.put(2, Lists.newArrayList(Pair.of(1,1), Pair.of(3,1)));
        g.nodesAndEdges.put(3, Lists.newArrayList(Pair.of(2,1), Pair.of(4,1)));
        g.nodesAndEdges.put(4, Lists.newArrayList(Pair.of(1,1), Pair.of(3,1)));

        assertTrue(DetectCycleUndirectedGraphDFS.isGraphCyclic(g));
    }

    @Test
    public void testIsGraphCyclic_no_cycle() {
        Graph<Integer> g = new Graph<>();
        g.nodesAndEdges.put(1, Lists.newArrayList(Pair.of(2,1)));
        g.nodesAndEdges.put(2, Lists.newArrayList(Pair.of(1,1), Pair.of(3,1)));
        g.nodesAndEdges.put(3, Lists.newArrayList(Pair.of(2,1), Pair.of(4,1)));
        g.nodesAndEdges.put(4, Lists.newArrayList(Pair.of(3,1)));

        assertFalse(DetectCycleUndirectedGraphDFS.isGraphCyclic(g));
    }
}
