package algo.graphbased;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleUndirectedGraphDFS {

    /**
     * Uses DFS algorithm
     * Say a graph has a cycle: 1-2-3-4-1
     * Say DFS starts at 1
     * isGraphCyclic(g, 1, -1, visited)
     * ...adj of 1: 2, 4
     * ...adds 2 to visited
     * ...isGraphCyclic(g, 2, 1, visited)  -- calls with parent=1
     * ......adj of 2: 1, 3
     * ......adds 2 to visited
     * ......isGraphCyclic(g, 3, 2, visited) -- calls with parent=2
     * .........adds 3 to visited
     * .........adj of 3: 2, 4
     * .........isGraphCyclic(g, 4, 3, visited)
     * ............adds 4 to visited
     * ............adj of 4: 1, 3
     * ............finds 1 as visited
     * ............finds 1 is visited but its not parent of 4, therefore there is cycle
     *
     */
    public static boolean isGraphCyclic(Graph<Integer> g) {
        Set<Integer> nodes = g.getNodes();
        for (int node : nodes) {
            Set<Integer> visited = new HashSet<>();
            if (isGraphCyclic(g, node, -1, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isGraphCyclic(Graph<Integer> g, int node, int parentNode, Set<Integer> visited) {
        visited.add(node);
        Set<Pair<Integer, Integer>> adjacents = g.getAdjacents(node);
        for (Pair<Integer, Integer> adjNode : adjacents) {
            if (!visited.contains(adjNode.getLeft())) {
                visited.add(adjNode.getLeft());
                isGraphCyclic(g, adjNode.getLeft(), node, visited);
            } else if (adjNode.getLeft() != parentNode) {
                return true;
            }
        }
        return false;
    }
}
