package algo.arraybased;

import java.util.Arrays;

/**
 * 2 Sum problem.
 *
 * Given a sorted array, find 2 numbers that sum up to S. Array can contain positive and negative integers.
 *
 * To solve this in O(N) time, we can keep two indices – one in the beginning (start) and the other in the end (end).
 * If the sum of the current two numbers is greater than S, we move the end pointer backward by one step.
 * If the sum is smaller than S, we move the start pointer forward by one step.
 *
 */
public class TwoNumbersEqualToSumProblem {

    // Uses 2 pointer technique
    public static int[] findTwoSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int st = 0;
        int en = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int s = arr[st] + arr[en];
            if (s == sum) {
                return new int[]{st, en};
            } else if (s < sum) {
                st++;
            } else {
                en--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(findTwoSum(arr, 9)));
        System.out.println(Arrays.toString(findTwoSum(arr, 5)));
        System.out.println(Arrays.toString(findTwoSum(arr, 11)));
        System.out.println(Arrays.toString(findTwoSum(arr, 19)));
    }
}

