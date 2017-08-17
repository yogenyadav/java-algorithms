package algo.arraybased;

/**
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have
 * a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it
 * twice to the left.
 *
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of
 * num in shiftArr. If num isn’t in shiftArr, return -1.
 *
 * Algorithm:
 * 1. Find a pivot point at which the shifted array splits into 2 sub-arrays where each sub-array is in
 *    ascending order.
 * 2. Then apply the binary search in the relevant array to find the number.
 *
 * Finding pivot point
 * 1. You can scan array to find out O(N).
 * 2. More efficient way is to modify binary search to find pivot point O(LogN)
 *    Pivot point satisfies condition: array[pivot - 1] > array[pivot]
 */
public class ShiftedArraySearch {

    static int shiftedArrSearch(int[] shiftArr, int num) {
        int pivotIndex = findPivotPoint(shiftArr, 0, shiftArr.length - 1);

        if (num == shiftArr[pivotIndex]) {
            return pivotIndex;
        }
        if (num == shiftArr[pivotIndex - 1]) {
            return pivotIndex - 1;
        }

        int startIndex = 0;
        int endIndex = shiftArr.length - 1;
        if (num < shiftArr[pivotIndex - 1]) {
            endIndex = pivotIndex - 1;
        } else {
            startIndex = pivotIndex;
        }
        return binarySearch(shiftArr, num, startIndex, endIndex);
    }

    static int binarySearch(int[] shiftArr, int num, int startIndex, int endIndex) {
        if (shiftArr == null
                || shiftArr.length == 0
                || startIndex > endIndex
                || (startIndex == endIndex && shiftArr[startIndex] != num && shiftArr[endIndex] != num)) {
            return -1;
        }

        int mid = (startIndex + endIndex) / 2; // average is right in center

        if (shiftArr[mid] < num) {
            startIndex = mid + 1;
        } else if (shiftArr[mid] > num) {
            endIndex = mid - 1;
        } else {
            return mid;
        }
        return binarySearch(shiftArr, num, startIndex, endIndex);
    }

    static int findPivotPoint(int[] shiftArr, int startIndex, int endIndex) {
        if (shiftArr == null
                || shiftArr.length == 0
                || startIndex > endIndex) {
            return -1;
        }

        int mid = (startIndex + endIndex) / 2; // average is right in center

        if (shiftArr[mid] > shiftArr[0]) {
            startIndex = mid + 1;
        } else if (shiftArr[mid - 1] > shiftArr[mid]) {
            return mid;
        } else {
            endIndex = mid - 1;
        }
        return findPivotPoint(shiftArr, startIndex, endIndex);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] shiftArr = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        System.out.println("pivot idx: " + findPivotPoint(shiftArr, 0, shiftArr.length - 1));

        System.out.println("7 idx: " + shiftedArrSearch(shiftArr, 7));
        System.out.println("1 idx: " + shiftedArrSearch(shiftArr, 1));
        System.out.println("10 idx: " + shiftedArrSearch(shiftArr, 10));
        System.out.println("11 idx: " + shiftedArrSearch(shiftArr, 11));

    }
}
