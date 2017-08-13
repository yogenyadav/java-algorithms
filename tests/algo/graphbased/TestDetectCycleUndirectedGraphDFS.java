package algo.graphbased;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDetectCycleUndirectedGraphDFS {
    @Test
    public void testIsGraphCyclic_has_cycle() {
        Graph<Integer> g = new Graph<>();
        g.nodesAndEdges.put(1, Lists.newArrayList(2, 4));
        g.nodesAndEdges.put(2, Lists.newArrayList(1, 3));
        g.nodesAndEdges.put(3, Lists.newArrayList(2, 4));
        g.nodesAndEdges.put(4, Lists.newArrayList(1, 3));

        assertTrue(DetectCycleUndirectedGraphDFS.isGraphCyclic(g));
    }

    @Test
    public void testIsGraphCyclic_no_cycle() {
        Graph<Integer> g = new Graph<>();
        g.nodesAndEdges.put(1, Lists.newArrayList(2));
        g.nodesAndEdges.put(2, Lists.newArrayList(1, 3));
        g.nodesAndEdges.put(3, Lists.newArrayList(2, 4));
        g.nodesAndEdges.put(4, Lists.newArrayList(3));

        assertFalse(DetectCycleUndirectedGraphDFS.isGraphCyclic(g));
    }
}
