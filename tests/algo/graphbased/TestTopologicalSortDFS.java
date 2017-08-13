package algo.graphbased;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestTopologicalSortDFS {

    @Test
    public void testTopologicalSort() {
        Graph<Integer> g = new Graph();
        g.nodesAndEdges.put(1, Lists.newArrayList(3));
        g.nodesAndEdges.put(2, Lists.newArrayList(3, 5));
        g.nodesAndEdges.put(3, Lists.newArrayList(4));
        g.nodesAndEdges.put(4, Lists.newArrayList(6));
        g.nodesAndEdges.put(5, Lists.newArrayList(6));
        g.nodesAndEdges.put(6, Lists.newArrayList(7));
        g.nodesAndEdges.put(7, Lists.newArrayList());

        List<Integer> topSortList = TopologicalSortDFS.topologicalSort(g);
        assertEquals(ImmutableList.of(2, 5, 1, 3, 4, 6, 7), topSortList);
    }
}
