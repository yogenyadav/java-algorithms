package algo.matrixbased;

import org.junit.Assert;

public class ClockwiseSpiral {

    public static int[][] createSpiral(int n) {

        if (n < 0) {
            return new int[][]{};
        }

        // intial start and end indexes based on worked out example for each direction
        // left to right
        int rowR = -1;
        int minColR = -1;
        int maxColR = n;

        // up to down
        int minRowD = 0;
        int maxRowD = n;
        int colD = n;

        // right to left
        int rowL = n;
        int minColL = -1;
        int maxColL = n-1;

        // down to up
        int minRowU = 0;
        int maxRowU = n-1;
        int colU = -1;

        int[][] matrix = new int[n][n];

        int num = 0;
        while (num < n*n) {
            // adjust left to right indexes
            // left to right fill is column wise fill
            // for each iteration row goes up by 1, and columns squeezed in by one on both ends
            rowR++; minColR++; maxColR--;
            num = fillLeftToRight(matrix, rowR, minColR, maxColR, num);

            // adjust up to down indexes
            // up to down fill is row wise fill
            // for each iteration col goes down by 1 (as we start up to down fill from last column),
            // and rows are squeezed in by one on both ends
            minRowD++; maxRowD--; colD--;
            num = fillUpToDown(matrix, minRowD, maxRowD, colD, num);

            // adjust right to left indexes
            // right to left fill is column wise fill
            // for each iteration row goes down by 1 (as we start right to left fill from last row),
            // and columns are squeezed in by one on both ends
            rowL--; minColL++; maxColL--;
            num = fillRightToLeft(matrix, rowL, minColL, maxColL, num);

            // adjust down to up indexes
            // down to up fill is row wise fill
            // for each iteration column goes up by 1 (as we have started down to up fill from first column),
            // and rows are squeezed in by one on both ends
            minRowU++; maxRowU--; colU++;
            num = fillDownToUp(matrix, minRowU, maxRowU, colU, num);
        }

        return matrix;
    }

    private static int fillLeftToRight(int[][] matrix, int rowR, int minColR, int maxColR, int num) {
        for (int c = minColR; c <= maxColR; c++) {
            num++;
            matrix[rowR][c] = num;
        }
        return num;
    }

    private static int fillUpToDown(int[][] matrix, int minRowD, int maxRowD, int colD, int num) {
        for (int r = minRowD; r <= maxRowD; r++) {
            num++;
            matrix[r][colD] = num;
        }
        return num;
    }

    private static int fillRightToLeft(int[][] matrix, int rowL, int minColL, int maxColL, int num) {
        for (int c = maxColL; c >= minColL; c--) {
            num++;
            matrix[rowL][c] = num;
        }
        return num;
    }

    private static int fillDownToUp(int[][] matrix, int minRowU, int maxRowU, int colU, int num) {
        for (int r = maxRowU; r >= minRowU; r--) {
            num++;
            matrix[r][colU] = num;
        }
        return num;
    }

    public static void main(String args[]) {
        validate(new int[][] {}, 0);
        validate(new int[][] {}, -1);
        validate(new int[][] { { 1 } }, 1);
        validate(new int[][] {
                        { 1, 2 },
                        { 4, 3 }},
                2);
        validate(new int[][] {
                        { 1, 2, 3 },
                        { 8, 9, 4 },
                        { 7, 6, 5 }},
                3);
        validate(new int[][] {
                        { 1, 2, 3, 4},
                        { 12, 13, 14, 5},
                        { 11, 16, 15, 6},
                        { 10, 9, 8, 7}},
                4);
        validate(new int[][] {
                        { 1, 2, 3, 4, 5},
                        { 16, 17, 18, 19, 6},
                        { 15, 24, 25, 20, 7},
                        { 14, 23, 22, 21, 8},
                        { 13, 12, 11, 10, 9}},
                5);
        validate(new int[][] {
                        { 1, 2, 3, 4, 5, 6 },
                        { 20, 21, 22, 23, 24, 7 },
                        { 19, 32, 33, 34, 25, 8 },
                        { 18, 31, 36, 35, 26, 9 },
                        { 17, 30, 29, 28, 27, 10 },
                        { 16, 15, 14, 13, 12, 11 }},
                6);
        validate(new int[][] {
                        { 1, 2, 3, 4, 5, 6, 7},
                        { 24, 25, 26, 27, 28, 29, 8},
                        { 23, 40, 41, 42, 43, 30, 9},
                        { 22, 39, 48, 49, 44, 31, 10},
                        { 21, 38, 47, 46, 45, 32, 11},
                        { 20, 37, 36, 35, 34, 33, 12 },
                        { 19, 18, 17, 16, 15, 14, 13 }},
                7);
        System.out.println("Success!");
    }

    private static void validate(int[][] expectedArray, int n) {
        Assert.assertArrayEquals(expectedArray, ClockwiseSpiral.createSpiral(n));
    }
}
