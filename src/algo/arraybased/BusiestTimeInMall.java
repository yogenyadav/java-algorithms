package algo.arraybased;

/**
 * Each data point is represented as an integer array whose size is 3.
 * The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and whether the visitors entered or exited the mall (0 for exit and 1 for entrance)
 *
 * findBusiestPeriod that returns the time at which the mall reached its busiest moment last year.
 * Assume that the array data is sorted in an ascending order by the timestamp.
 *
 */
public class BusiestTimeInMall {
    static int findBusiestPeriod(int[][] data) {
        int prevTime = data[0][0];
        int cumCount = 0;
        int time = 0;
        int maxCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (prevTime != data[i][0]) {
                if (cumCount > maxCount) {
                    maxCount = cumCount;
                    time = prevTime;
                }
                prevTime = data[i][0];
            }

            if (data[i][2] == 1) {
                cumCount = cumCount + data[i][1];
            } else {
                cumCount = cumCount - data[i][1];
            }
        }

        if (cumCount > maxCount) {
            return prevTime;
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] input1 = {{1487799426, 21, 1}};
        System.out.println(findBusiestPeriod(input1));

        int[][] input2 = {
                {1487799425, 21, 0},
                {1487799427, 22, 1},
                {1487901318, 7, 0}};
        System.out.println(findBusiestPeriod(input2));

        int[][] input3 = {
                {1487799425, 21, 1},
                {1487799425, 4, 0},
                {1487901318, 7, 0}};
        System.out.println(findBusiestPeriod(input3));

        int[][] input4 = {
                {1487799425, 14, 1},
                {1487799425, 4, 0},
                {1487799425, 2, 0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1, 0},
                {1487901211, 7, 1},
                {1487901211, 7, 0}};
        System.out.println(findBusiestPeriod(input4));

        int[][] input5 = {
                {1487799425, 14, 1},
                {1487799425, 4, 1},
                {1487799425, 2, 1},
                {1487800378, 10, 1},
                {1487801478, 18, 1},
                {1487901013, 1, 1},
                {1487901211, 7, 1},
                {1487901211, 7, 1}};
        System.out.println(findBusiestPeriod(input5));

        int[][] input6 = {
                {1487799425, 14, 1},
                {1487799425, 4, 0},
                {1487799425, 2, 0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 19, 1},
                {1487801478, 1, 0},
                {1487801478, 1, 1},
                {1487901013, 1, 0},
                {1487901211, 7, 1},
                {1487901211, 8, 0}};
        System.out.println(findBusiestPeriod(input6));

    }
}
