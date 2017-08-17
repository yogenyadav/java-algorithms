package algo.arraybased;

import java.util.Arrays;

/**
 * Using two pointer technique.
 * 1. Pointer1 - keeps moving along entire array
 * 2. Pointer2 - it lags behind by 1 everytime a zero is encountered.
 * 3. Pointer2 always points to the index where next non-zero number can be moved.
 * 4. In the end wherever pointer2 is, from there till end should be filled with zeros.
 *
 */
public class MoveZerosToTheEnd {

    public static void moveZeros(int[] array) {

        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < array.length) {
            if (array[ptr1] == 0) {
                ptr1++;
            } else {
                array[ptr2] = array[ptr1];
                ptr1++;
                ptr2++;
            }
        }
        while (ptr2 < array.length) {
            array[ptr2] = 0;
            ptr2++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 2, 3, 0, 4, 5, 0, 0};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
