package algo.arraybased;

public class ReverseCharsInPlace {

	/**
	 * http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
	 * 1) Let input string be 'str[]' and length of string be 'n'
	 * 2) l = 0, r = n-1
	 * 3) While l is smaller than r, do following
	 *   a) If str[l] is not an alphabetic character, do l++
	 *   b) Else If str[r] is not an alphabetic character, do r--
	 *   c) Else swap str[l] and str[r]
	 */
	public static void reverseInPlaceWithoutAffectingSpecialChars(char[] str) {

	}

	public static void reverseInPlace(char[] str) {
		int len = str.length - 1;
		for (int i = 0; i < len; i++) {
			char c1 = str[i];
			char c2 = str[len];
			str[i] = c2;
			str[len] = c1;
			len--;
			if ((str.length % 2 != 0) && (i == str.length / 2))
				break;
		}
	}

	public static void main(String[] args) {

		String s = "ABCDEFGHIJK";
		ReverseCharsInPlace.reverseInPlace(s.toCharArray());
		System.out.println(s);
	}
}
