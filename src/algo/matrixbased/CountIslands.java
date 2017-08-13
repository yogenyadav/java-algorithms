package algo.matrixbased;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D array binaryMatrix of 0s and 1s, implement a function getNumberOfIslands that returns the
 * number of islands of 1s in binaryMatrix.
 *
 * An island is defined as a group of adjacent values that are all 1s. A cell in binaryMatrix is considered
 * adjacent to another cell if they are next to each either on the same row or column. Note that two values of 1
 * are not part of the same island if they’re sharing only a mutual “corner” (i.e. they are diagonally neighbors).
 *
 */
public class CountIslands {

    public static int getNumberOfIslandsUsingDFS(int[][] binaryMatrix) {
        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;

        int numberOfIslands = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (binaryMatrix[r][c] == 1) { // since 1, its an island
                    numberOfIslands++;
                    markIslandDFS(binaryMatrix, r, c, rows, cols); // mark extent of this island
                }
            }
        }
        return numberOfIslands;
    }

    // uses DFS to mark extent of island in 4 directions (up, down, left, right, no across)
    private static void markIslandDFS(int[][] binaryMatrix, int r, int c, int rows, int cols) {
        if (binaryMatrix[r][c] == 1) {
            binaryMatrix[r][c] = 0;
        } else {
            return;
        }
        if (r+1 < rows) {
            markIslandDFS(binaryMatrix, r+1, c, rows, cols);
        }
        if (r-1 >= 0) {
            markIslandDFS(binaryMatrix, r-1, c, rows, cols);
        }
        if (c+1 < cols) {
            markIslandDFS(binaryMatrix, r, c+1, rows, cols);
        }
        if (c-1 >= 0) {
            markIslandDFS(binaryMatrix, r, c-1, rows, cols);
        }
    }

    public static int getNumberOfIslandsUsingBFS(int[][] binaryMatrix) {
        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;

        int numberOfIslands = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (binaryMatrix[r][c] == 1) { // since 1, its an island
                    numberOfIslands++;
                    markIslandBFS(binaryMatrix, new Node(r, c), rows, cols); // mark extent of this island
                }
            }
        }
        return numberOfIslands;

    }

    // uses BFS to mark extent of island in 4 directions (up, down, left, right, no across)
    private static void markIslandBFS(int[][] binaryMatrix, Node n, int rows, int cols) {
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (binaryMatrix[node.r][node.c] == 1) {
                binaryMatrix[node.r][node.c] = 0;
                pushIfIslandPart(q, binaryMatrix, node.up(), rows, cols);
                pushIfIslandPart(q, binaryMatrix, node.down(), rows, cols);
                pushIfIslandPart(q, binaryMatrix, node.left(), rows, cols);
                pushIfIslandPart(q,binaryMatrix,  node.right(), rows, cols);
            }
        }
    }

    private static void pushIfIslandPart(Queue<Node> q, int[][] binaryMatrix, Node n, int rows, int cols) {
        if (n.r >= 0 && n.r < rows && n.c >= 0 && n.c < cols && binaryMatrix[n.r][n.c] == 1) {
            q.offer(n);
        }
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public Node up() {
            return new Node(this.r-1, c);
        }
        public Node down() {
            return new Node(this.r+1, c);
        }
        public Node left() {
            return new Node(this.r, c-1);
        }
        public Node right() {
            return new Node(this.r, c+1);
        }
    }
    public static void main(String[] args) {
        int[][] binaryMatrix1 = new int[][]{
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(getNumberOfIslandsUsingDFS(binaryMatrix1));

        int[][] binaryMatrix2 = new int[][]{
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(getNumberOfIslandsUsingBFS(binaryMatrix2));
    }
}
