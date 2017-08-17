package algo.arraybased;

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

		char[] c = s.toCharArray();
		RotateArrayByN.rotateByN2(c, 4);
		System.out.println(new String(c));
	}
}