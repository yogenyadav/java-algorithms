package algo.graphbased;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestTopologicalSortDFS {

    @Test
    public void testTopologicalSort() {
        Graph<Integer> g = new Graph();
        g.nodesAndEdges.put(1, Lists.newArrayList(Pair.of(3,1)));
        g.nodesAndEdges.put(2, Lists.newArrayList(Pair.of(3,1), Pair.of(5,1)));
        g.nodesAndEdges.put(3, Lists.newArrayList(Pair.of(4,1)));
        g.nodesAndEdges.put(4, Lists.newArrayList(Pair.of(6,1)));
        g.nodesAndEdges.put(5, Lists.newArrayList(Pair.of(6,1)));
        g.nodesAndEdges.put(6, Lists.newArrayList(Pair.of(7,1)));
        g.nodesAndEdges.put(7, Lists.newArrayList());

        List<Integer> topSortList = TopologicalSortDFS.topologicalSort(g);
        assertEquals(ImmutableList.of(2, 5, 1, 3, 4, 6, 7), topSortList);
    }
}
