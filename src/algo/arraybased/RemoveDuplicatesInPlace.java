package algo.arraybased;

/**
 * Array is sorted
 *
 * Algorithm:
 * Uses 2 pointer technique.
 *
 */
public class RemoveDuplicatesInPlace {

    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0; //slow runner
        for (int j = 0; j < arr.length; j++) { // fast runner
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9, 10, 11, 11};
        int lastIndex = removeDuplicates(arr);
        for (int i = 0; i < lastIndex; i++) {
            System.out.println(arr[i]);
        }
    }
}
