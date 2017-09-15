package algo.nocategory;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public static int[] yearWithMostpeople1(int[][] birthDeathPair) {

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

    /**
     * more optimized
     * time complexity (p - number of people)
     * mark +1/-1 - O(p)
     * count population - O(y) - y is the range from min birth to max death
     * overall - O(p) + O(y) - saves the cycles to calculate min and max though.
     * This algorithm is slower than earlier because of
     * - all the boxing/unboxing.
     * - map hash calculation.
     *
     */
    public static int[] yearWithMostpeople2(int[][] birthDeathPair) {

        int minBirthYear = Integer.MAX_VALUE;
        int maxDeathYear = Integer.MIN_VALUE;

        Map<Integer, Integer> popByYear = new HashMap<>();
        for (int r = 0; r < birthDeathPair.length; r++) {
            int birthYear = birthDeathPair[r][0];
            if (birthYear < minBirthYear) {
                minBirthYear = birthYear;
            }
            int deathYear = birthDeathPair[r][1];
            if (deathYear > maxDeathYear) {
                maxDeathYear = deathYear;
            }

            popByYear.merge(birthYear, 1, (a, b) -> a + b);

            Integer value = popByYear.get(deathYear + 1);
            if (value == null) {
                popByYear.put((deathYear + 1), -1);
            } else {
                popByYear.put((deathYear + 1), value-1);
            }
        }

        int[] max = {0, 0};
        int pop = 0;
        for (int i = minBirthYear; i <= maxDeathYear + 1; i++) {
            Integer v = popByYear.get(i);
            if (v != null) {
                popByYear.put(i, v + pop);
                pop = v + pop;
                if (max[1] < pop) {
                    max[0] = i;
                    max[1] = pop;
                }
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
        Stopwatch sw = Stopwatch.createStarted();
        int[] yearPop = yearWithMostpeople1(birthDeathPair);
        System.out.println(sw.elapsed(TimeUnit.NANOSECONDS));
        System.out.println(yearPop[0] + ": " + yearPop[1]);

        sw.stop();
        sw.start();
        yearPop = yearWithMostpeople2(birthDeathPair);
        System.out.println(sw.elapsed(TimeUnit.NANOSECONDS));
        System.out.println(yearPop[0] + ": " + yearPop[1]);
    }
}
