package algo.arraybased;

/**
 * Given an array of non-negative numbers, find continuous sub-array with sum to S.
 * Array is not sorted.
 *
 * Algorithm:
 * Uses sliding window technique.
 *
 * 1. Start with two pointers that represent the sub-array. Both pointers at index = 0.
 *    If sum == number at start index then return the indexes.
 * 2. If the sum of current sub-array is smaller than S, move the end pointer one step forward.
 * 3. If the sum is larger than S, move the start pointer one step forward.
 * 4. Once the current sum equals to S, we found the target.
 *
 * Initialize a variable curr_sum as first element. curr_sum indicates the sum of current sub-array.
 * Start from the second element and add all elements one by one to the curr_sum.
 * If curr_sum becomes equal to sum, then print the solution.
 * If curr_sum exceeds the sum, then remove trailing elemnents while curr_sum is greater than sum.
 *
 */
public class SubarrayWithGivenSum {
}
