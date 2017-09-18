package algo.arraybased;

import java.util.HashSet;
import java.util.Set;

public class RotateArrayByN {

	public static char[] rotatebyOne(char[] str) {
		int len = str.length;
		char tmp = str[len - 1];
		for(int i = len-1; i >= 0; i--) {
			if (i == 0)
				str[i] = tmp;
			else{
				str[i] = str[i-1];
			}
        }
		return str;
	}

	public static char[] rotateByN(char[] str, int n) {
		int times = n;
		if (n >= str.length)
			times = n-str.length;
		for(int i=0; i<times; i++){
			str = RotateArrayByN.rotatebyOne(str);
			System.out.format("the str= %s \n", new String(str));
		}
		return str;
	}

	// More efficient
	//	Original List                   : 1 2 3 4 5 6 7
	//	After reversing all numbers     : 7 6 5 4 3 2 1
	//	After reversing first k numbers : 5 6 7 4 3 2 1
	//	After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
	public static void rotateByN2(char[] str, int n) {
		int len = str.length;
		reverse(str, 0, len-1);
		reverse(str, 0, n-1);
		reverse(str, n, len-1);
	}

    /**
     * O(n) solution
     *
     */
	public static void rotateByN3(char[] str, int n) {
		Set<Integer> rotated = new HashSet<>();
		for (int i = 0; i < str.length; i++) {
			if (!rotated.contains(i)) {
				rotate(str, i, n, rotated);
			}
		}
	}

	private static void rotate(char[] str, int startIdx, int rotateBy, Set<Integer> rotated) {
		int moveToIdx = (startIdx + rotateBy) < str.length ? (startIdx + rotateBy) : (startIdx + rotateBy) - str.length;
		char tmp1 = str[startIdx];
		char tmp2 = str[moveToIdx];

		while (moveToIdx != startIdx) {
			str[moveToIdx] = tmp1;
			tmp1 = tmp2;
			rotated.add(moveToIdx);
			moveToIdx = (moveToIdx + rotateBy) < str.length ? (moveToIdx + rotateBy) : (moveToIdx + rotateBy) - str.length;
			tmp2 = str[moveToIdx];
		}
		str[moveToIdx] = tmp1;
		rotated.add(moveToIdx);
	}

	private static void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(RotateArrayByN.rotateByN(s.toCharArray(), 27));

		char[] c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		RotateArrayByN.rotateByN2(c1, 4);
		System.out.println(new String(c1));

		char[] c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		RotateArrayByN.rotateByN3(c2, 3);
		System.out.println(new String(c2));
	}
}