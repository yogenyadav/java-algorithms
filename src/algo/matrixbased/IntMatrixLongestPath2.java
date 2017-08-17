package algo.matrixbased;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * given a matrix of integers, find longest path from a given node such that
 * 1. From a given node allowed movements are up, down, left, right (no diagonal).
 * 2. Move to next node only of next node is greater than current node.
 *
 */
public class IntMatrixLongestPath2 {

    public static List<List<Node>> longestPath(Graph g, Node node) {
        List<Node> path = new ArrayList<>();
        List<List<Node>> allPaths = new ArrayList<>();
        longestPath(g, node, path, allPaths);
        return allPaths;
    }

    /**
     * Uses DFS algorithm.
     *
     * @param g graph
     * @param node next child node to be explored
     * @param path current path of nodes so far
     * @param allPaths list of paths found so far
     */
    public static void longestPath(Graph g, Node node, List<Node> path, List<List<Node>> allPaths) {
        List<Node> adjacents = g.getAdjacent(node);
        boolean nodeIsExplored = false;
        for (Node n : adjacents) {
            if (!n.visited && n.data > node.data) {
                nodeIsExplored = true;
                n.visited = true;
                path.add(n);
                longestPath(g, n, path, allPaths);
            }
        }
        // there was nothing left to explore for this node either
        // 1. all its adjacents were visited or
        // 2. all adjacents are < this node
        // i.e. this is one of the the longest path, so store it in allPaths
        // then back track to earlier node and start over to explore other paths.
        if (!nodeIsExplored) {
            allPaths.add(Lists.newArrayList(path)); // add final path
            path.remove(path.size() - 1); // remove itself from path
        } else if (path.size() > 0) {
            path.remove(path.size() - 1); // remove itself from path
        }
    }

    static class Graph {
        private final int rows;
        private final int cols;
        int[][] matrix;

        Graph(int[][] matrix) {
            this.matrix = matrix;
            this.rows = this.matrix.length;
            this.cols = this.matrix[0].length;
        }

        List<Node> getNodes() {
            int rows = this.matrix.length;
            int cols = this.matrix[0].length;
            List<Node> nodes = new ArrayList<>();
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    nodes.add(new Node(r, c, this.matrix[r][c]));
                }
            }
            return nodes;
        }

        List<Node> getAdjacent(Node n) {
            List<Node> nodes = new ArrayList<>();

            nodes.addAll(getAdjacentNodesForIndex(n, 1));
            nodes.addAll(getAdjacentNodesForIndex(n, -1));

            return nodes;
        }

        private Collection<? extends Node> getAdjacentNodesForIndex(Node n, int index) {
            int row = n.row + index;
            int col = n.col + index;
            List<Node> nodes = new ArrayList<>();
            if (row >= 0 && row < this.rows) {
                nodes.add(new Node(row, n.col, this.matrix[row][n.col]));
            }
            if (col >= 0 && col < this.cols) {
                nodes.add(new Node(n.row, col, this.matrix[n.row][col]));
            }
            return nodes;
        }
    }

    static class Node {
        int row;
        int col;
        int data;
        boolean visited = false;
        Node(int r, int c, int data) {
            this.row = r;
            this.col = c;
            this.data = data;
        }
    }
}
