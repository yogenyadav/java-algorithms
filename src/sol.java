import java.util.ArrayList;


class sol {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (arr1[len1 - 1] < arr2[0]) {
            return null;
        }

        int idx1 = 0;
        int idx2 = 0;
    /*
     arr1 = {7,8,9};
     arr2 = {1,2,3,7,8};
    */
        int[] dups = new int[len2];
        for (int i = 0; i < len1; i++) {

            if (idx1 >= len1) {
                return dups;
            }
            if (idx2 >= len2) {
                return dups;
            }

            int a = arr1[idx1];
            int b = arr2[idx2];
            if (a == b) {
                idx1++;
                idx2++;
                dups[dups.length] = a;
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
        System.out.println(findDuplicates(arr1, arr2));
    }

}