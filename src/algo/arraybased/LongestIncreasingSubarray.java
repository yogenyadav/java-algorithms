package algo.arraybased;

/**
 * Given an array, return the length of the longest increasing subarray.
 *
 * Algorithm:
 * Uses sliding window technique.
 *
 * 1. We keep two pointers start and end to denote the subarray arr[start: end]
 * 2. If the current array is increasing, which means arr[end] > arr[end – 1], we can increase the
 * current array by add 1 to end.
 * 3. Otherwise, we can ignore everything before pointer end. So just set start = end
 * 4. In the end, just return the longest subarray.
 *
 */
public class LongestIncreasingSubarray {
}
