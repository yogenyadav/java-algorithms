package algo.arraybased;

import java.util.Arrays;

/**
 * Algorithm:
 * Uses 2 pointer technique.
 *
 */
public class FindDuplicates {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int idx1 = 0;
        int idx2 = 0;

        int[] dups = new int[len1 + len2];
        int dupsidx = 0;

        while (idx1 < len1 && idx2 < len2) {

            int a = arr1[idx1];

            int b = arr2[idx2];

            if (a == b) {
                idx1++;
                idx2++;
                dups[dupsidx] = a;
                dupsidx++;
            } else if (a < b) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return dups;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 5, 6, 7};
        int arr2[] = {3, 6, 7, 8, 20};
        System.out.println(Arrays.toString(findDuplicates(arr1, arr2)));

        int arr3[] = {1, 2, 3};
        int arr4[] = {4, 5 ,6};
        System.out.println(Arrays.toString(findDuplicates(arr3, arr4)));

        int arr5[] = {1};
        int arr6[] = {1, 5 ,6};
        System.out.println(Arrays.toString(findDuplicates(arr5, arr6)));

        int arr7[] = {1, 5 ,6};
        int arr8[] = {1};
        System.out.println(Arrays.toString(findDuplicates(arr7, arr8)));

        int arr9[] = {6};
        int arr10[] = {1, 5 ,6};
        System.out.println(Arrays.toString(findDuplicates(arr9, arr10)));

        int arr11[] = {1, 5 ,6};
        int arr12[] = {6};
        System.out.println(Arrays.toString(findDuplicates(arr11, arr12)));

        int arr13[] = {};
        int arr14[] = {1, 2, 3};
        System.out.println(Arrays.toString(findDuplicates(arr13, arr14)));

        int arr15[] = {1, 2, 3};
        int arr16[] = {};
        System.out.println(Arrays.toString(findDuplicates(arr15, arr16)));

        int arr17[] = {5};
        int arr18[] = {1, 5 ,6};
        System.out.println(Arrays.toString(findDuplicates(arr17, arr18)));

        int arr19[] = {1, 5 ,6};
        int arr20[] = {5};
        System.out.println(Arrays.toString(findDuplicates(arr19, arr20)));

        int arr21[] = {1, 2, 3, 4, 5};
        int arr22[] = {6, 7, 8};
        System.out.println(Arrays.toString(findDuplicates(arr21, arr22)));

        int arr23[] = {2, 4, 6, 8, 10};
        int arr24[] = {2, 3, 5};
        System.out.println(Arrays.toString(findDuplicates(arr23, arr24)));

        int arr25[] = {2, 3, 5};
        int arr26[] = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(findDuplicates(arr25, arr26)));

        int arr27[] = {2, 4, 6, 8, 10};
        int arr28[] = {1, 3, 10};
        System.out.println(Arrays.toString(findDuplicates(arr27, arr28)));

        int arr29[] = {1, 3, 10};
        int arr30[] = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(findDuplicates(arr29, arr30)));
    }
}
