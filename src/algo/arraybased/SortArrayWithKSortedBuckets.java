package algo.arraybased;

/**
 * Given an array of  size N, with k sorted buckets of size m each; produce a full sorted array.
 * A[] = {1,5,9,   3,7,11,   4,8,12,  2,6,10}
 * m = 3
 * k = 4
 * N = 12
 * output[] = {1,2,3,4,5,6,7,8,9,10,11,12}
 * <p>
 * A[] = {1,2,3,  9,10,11,  4,5,6}
 * output[] = {1,2,3,4,5,6,7,8,9,10,11}
 * <p>
 * Algorithm
 * output[size of A]
 * bucketIndexes[size of k] - to remove an index set it to -1
 * bucketIndexes[0] - first bucket
 * bucketIndexes[2] - second bucket
 * bucketIndexes[k-1] - kth bucket
 * <p>
 * >>buckets are from 0 to k-1
 * <p>
 * put index of first elements from each bucket into bucketIndexes
 * >bucketIndexes[0,3,6]
 * <p>
 * find min value index in bucketIndexes[0,3,6]
 * >min value is at index 0 i.e. at bucketIndexes[0] which is index 0 in A
 * put min value in output
 * >output[A[bucketIndexes[0]]]
 * remove min index from bucketIndexes
 * >bucketIndexes[-1,3,6]
 * put next index from bucket from bucket 0 into bucketIndexes (as index of bucket 0 is removed)
 * >bucketIndexes[1,3,6]
 * <p>
 * find min value index in bucketIndexes[1,3,6]
 * >min value is at index 0 i.e. at bucketIndexes[0] which is index 1 in A
 * put min value in output
 * >output[A[bucketIndexes[0]]]
 * remove min index from bucketIndexes
 * >bucketIndexes[-1,3,6]
 * put next index from bucket from bucket 0 into bucketIndexes (as index of bucket 0 is removed)
 * >bucketIndexes[2,3,6]
 * <p>
 * find min value index in bucketIndexes[2,3,6]
 * >min value is at index 0 i.e. at bucketIndexes[0] which is index 2 in A
 * put min value in output
 * >output[A[bucketIndexes[0]]]
 * remove min index from bucketIndexes
 * >bucketIndexes[-1,3,6]
 * <p>
 * <p>
 * <p>
 * put next index from bucket from bucket 0 into bucketIndexes (as index of bucket 0 is removed)
 * >bucketIndexes[2,3,6]
 */
public class SortArrayWithKSortedBuckets {
}
