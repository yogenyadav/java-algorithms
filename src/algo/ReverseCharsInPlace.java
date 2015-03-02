package algo;

public class ReverseCharsInPlace {
	public static char[] reverseInPlace(char[] str) {
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
		return str;
	}

	public static void main(String[] args) {

		String s = "ABCDEFGHIJ";
		System.out.println(ReverseCharsInPlace.reverseInPlace(s.toCharArray()));
	}
}
