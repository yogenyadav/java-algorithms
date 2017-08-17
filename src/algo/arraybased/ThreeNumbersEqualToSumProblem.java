package algo.arraybased;

import java.util.Arrays;

/**
 * 3 Sum problem.
 *
 * Determine if any 3 integers in an array sum to 0.
 *
 * For example, for array [4, 3, -1, 2, -2, 10], the function should return true since 3 + (-1) + (-2) = 0.
 * To make things simple, each number can be used at most once.
 *
 * Let’s see how we can optimize it. I believe that most people have practiced with the popular question
 * 2sum – given a sorted array, find 2 numbers that sum up to S. To solve this in O(N) time, we can keep two
 * indices – one in the beginning (start) and the other in the end (end). If the sum of the current two numbers
 * is greater than S, we move the end pointer backward by one step. If the sum is smaller than S, we move the
 * start pointer forward by one step.
 *
 * When the two pointers meet each other, we know that no two numbers sum up to S.
 * The reason we can make it O(N) is that the array is sorted and we don’t need to check all the combinations.
 *
 * With the previous analysis, we can use the same technique on the 3sum question. As 2sum solution,
 * let’s sort the array first. Now if we fix one number X in the array, the problem becomes finding 2 numbers
 * that sum up to -X, which is exactly the 2sum question and can be solved in O(N) time.
 *
 * Therefore, we can iterate over each number and inside the loop, solve the sub-problem as 2sum.
 * To calculate the time complexity, sorting is O(NlogN), the outside loop is O(N) and the inside 2sum is O(N).
 * Therefore, the overall time complexity is O(N^2) and space complexity is O(1).
 *
 */
public class ThreeNumbersEqualToSumProblem {

    public static int[] findThreeSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        for (int i = 0; i < arr.length; i++) {
            int remainingTwoSum = sum - arr[i];
            int[] twoSumIndices = findTwoSum(arr, i+1, arr.length, remainingTwoSum);
            if (twoSumIndices.length == 2) {
                return new int[]{i, twoSumIndices[0], twoSumIndices[1]};
            }
        }
        return new int[]{};
    }

    public static int[] findTwoSum(int[] arr, int start, int end, int sum) {
        if (start > arr.length || end > arr.length || start >= end) {
            return new int[]{};
        }
        int st = start;
        int en = end-1;
        while (st < en) {
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
        System.out.println(Arrays.toString(findThreeSum(arr, 9)));
        System.out.println(Arrays.toString(findThreeSum(arr, 5)));
        System.out.println(Arrays.toString(findThreeSum(arr, 11)));
        System.out.println(Arrays.toString(findThreeSum(arr, 19)));
        System.out.println(Arrays.toString(findThreeSum(arr, 21)));
        System.out.println(Arrays.toString(findThreeSum(arr, 22)));
        System.out.println(Arrays.toString(findThreeSum(arr, 0)));
        System.out.println(Arrays.toString(findThreeSum(arr, -5)));
    }
}
