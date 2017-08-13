package algo.matrixbased;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestIntMatrixLongestPath {

    @Test
    public void testLongestPath() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        IntMatrixLongestPath.Graph g = new IntMatrixLongestPath.Graph(matrix);
        List<IntMatrixLongestPath.Node> nodes = g.getNodes();

        // test for 4
        IntMatrixLongestPath.Node testNode = nodes.get(3);
        List<List<IntMatrixLongestPath.Node>> allPaths = IntMatrixLongestPath.longestPath(g, testNode);
        // nodes.get(3) is 4.
        // 4 has adjacents = 1, 7, 5
        // paths from 4 are
        List<String> stringifiedPaths = stringifyPaths(allPaths, testNode);
        assertTrue(stringifiedPaths.contains("4589"));
        assertTrue(stringifiedPaths.contains("4789"));
        assertTrue(stringifiedPaths.contains("4569"));

        // test for 5
        testNode = nodes.get(4);
        allPaths = IntMatrixLongestPath.longestPath(g, testNode);
        // nodes.get(4) is 5.
        // 5 has adjacents = 2, 4, 8, 6
        // paths from 4 are
        stringifiedPaths = stringifyPaths(allPaths, testNode);
        assertTrue(stringifiedPaths.contains("589"));
        assertTrue(stringifiedPaths.contains("569"));

        // test for 2
        testNode = nodes.get(1);
        allPaths = IntMatrixLongestPath.longestPath(g, testNode);
        // nodes.get(1) is 2.
        // 2 has adjacents = 1, 5, 3
        // paths from 2 are
        stringifiedPaths = stringifyPaths(allPaths, testNode);
        assertTrue(stringifiedPaths.contains("2369"));
        assertTrue(stringifiedPaths.contains("2589"));
        assertTrue(stringifiedPaths.contains("2569"));
    }

    private List<String> stringifyPaths(List<List<IntMatrixLongestPath.Node>> allPaths, IntMatrixLongestPath.Node node) {
        List<String> stringifiedPaths = new ArrayList<>();
        for (List<IntMatrixLongestPath.Node> path : allPaths) {
            StringBuilder sb = new StringBuilder();
            for (IntMatrixLongestPath.Node n : path) {
                sb.append(n.data);
            }
            stringifiedPaths.add(node.data + sb.toString());
        }
        return  stringifiedPaths;
    }
}
