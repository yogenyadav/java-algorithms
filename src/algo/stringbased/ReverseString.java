package algo.stringbased;

import java.util.Arrays;

public class ReverseString {

    // Using 2 pointer technique
    public static void reverse2Ptr(char[] str) {
        int i = 0, j = str.length - 1;
        while (i < j) {
            swap(str, i, j);
            i++;
            j--;
        }
    }

    public static void reverse(char[] str) {
        int n = str.length;
        for (int i = 0; i < n / 2; i++) {
            swap(str, i, n - i - 1);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        char[] str1 = "abcde".toCharArray();
        reverse2Ptr(str1);
        System.out.println(Arrays.toString(str1));

        str1 = "abcde".toCharArray();
        reverse(str1);
        System.out.println(Arrays.toString(str1));
    }
}
