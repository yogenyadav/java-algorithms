package algo.arraybased;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr of unique positive integers, implement a function getDifferentNumber that finds the
 * smallest positive integer that is NOT in the array.
 *
 * Solutions
 * 1. Sort array
 *    Then iterate, if diff between current and next > 1 then return current + 1
 *    Time: NlogN for sort
 *    Space: sorting takes extra space
 *
 * 2. Using Map of Int to Boolean
 *    Time: O(N)
 *    Space: space for map
 *
 * 3. Using Boolean array
 *    Time: O(N)
 *    Space: space for array
 *
 */
public class FindADifferentNumber {

    static int getDifferentNumber(int[] arr) {

        Map<Integer, Boolean> m = new HashMap();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], true);
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i <= max; i++) {
            if (m.get(i) == null) {
                return i;
            }
        }
        return max+1;
    }

    static int getDifferentNumberUsingArray(int[] arr) {

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        boolean[] a = new boolean[max+1];
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]] = true;
        }

        for (int i = 0; i <= max; i++) {
            if (!a[i]) {
                return i;
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        System.out.println(getDifferentNumber(new int[]{0, 1, 2, 3})); // return 4
        System.out.println(getDifferentNumber(new int[]{1, 2, 3})); // returns 0
        System.out.println(getDifferentNumber(new int[]{0, 2, 4, 6})); // returns 1

        System.out.println(getDifferentNumberUsingArray(new int[]{0, 1, 2, 3})); // return 4
        System.out.println(getDifferentNumberUsingArray(new int[]{1, 2, 3})); // returns 0
        System.out.println(getDifferentNumberUsingArray(new int[]{0, 2, 4, 6})); // returns 1
    }
}
