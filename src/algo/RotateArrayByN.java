package algo;

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

	public static void main(String[] args) {

		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(RotateArrayByN.rotateByN(s.toCharArray(), 27));
	}
}