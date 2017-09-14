package algo.nocategory;

import java.util.Arrays;

public class YearWithMostPeople {

    /**
     * time complexity (p - number of people)
     * min - O(p)
     * max - O(p)
     * mark +1/-1 - O(p)
     * count population - O(y) - y is the range from min birth to max death
     * overall - O(p) + O(y)
     *
     * @param birthDeathPair - n x 2 array; a row contains birth year in [r][0] and death year in [r][1]
     */
    public static int[] yearWithMostpeople(int[][] birthDeathPair) {

        int minBirthYear = minBirthYear(birthDeathPair);
        int maxDeathYear = maxDeathYear(birthDeathPair);

        //array 0 index is at minBirthYear
        //so array is indexed like this: index = (year - minBirthYear)
        int[] arr = new int[maxDeathYear - minBirthYear + 2];
        Arrays.fill(arr, 0);
        for (int r = 0; r < birthDeathPair.length; r++) {
            int birthYear = birthDeathPair[r][0];
            int deathYear = birthDeathPair[r][1];
            arr[birthYear - minBirthYear] = arr[birthYear - minBirthYear] + 1; //birth year: population goes up by 1
            arr[deathYear + 1 - minBirthYear] = arr[deathYear + 1 - minBirthYear] - 1; //death year: year after death year population goes down by 1
        }

        int v = arr[0];
        int[] max = {0, 0};
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + v;
            v = arr[i];
            if (v > max[1]) {
                max[0] = minBirthYear + i;
                max[1] = v;
            }
        }
        return max;
    }

    private static int maxDeathYear(int[][] birthDeathPair) {
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < birthDeathPair.length; r++) {
            if (birthDeathPair[r][1] > max) {
                max = birthDeathPair[r][1];
            }
        }
        return max;
    }

    private static int minBirthYear(int[][] birthDeathPair) {
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < birthDeathPair.length; r++) {
            if (birthDeathPair[r][0] < min) {
                min = birthDeathPair[r][0];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] birthDeathPair = {
                {1, 35},
                {5, 65},
                {15, 75},
                {1, 55},
                {5, 35},
                {10, 70},
                {25, 75},
                {35, 50},
                {21, 45},
                {23, 77},
                {18, 88},
                {45, 60},
                {75, 100},
                {85, 99},
                {65, 77},
                {85, 100},
                {35, 80},
                {15, 55}
        };
        int[] yearPop = yearWithMostpeople(birthDeathPair);
        System.out.println(yearPop[0] + ": " + yearPop[1]);
    }
}
