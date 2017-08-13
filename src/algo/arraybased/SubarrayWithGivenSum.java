package algo.arraybased;

/**
 * Given an array of non-negative numbers, find continuous subarray with sum to S.
 *
 * Algorithm:
 * Uses sliding window technique.
 *
 * 1. Start with two pointers that represent the subarray.
 * 2. If the sum of current subarray is smaller than S, move the end pointer one step forward.
 * 3. If the sum is larger than S, move the start pointer one step forward.
 * 4. Once the current sum equals to S, we found the target.
 *
 */
public class SubarrayWithGivenSum {
}
