/*
 * This is a base 26 number generation algorithm
 */

public class GenerateExcelColumnNames {

	public static void main(String[] args) {
		System.out.println(base26(703));
	}
	private static String base26(int n){
	    if(n < 0)
	        throw new NumberFormatException();
	    char[] nos = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	    if (n == 0)
	        return "A";
	    StringBuilder s = new StringBuilder();
	    while(n >= 0){
	        int x = n % 26;
	        s.append(nos[x]);
	        n = n/26-1;
	    }
	    return reverse(s);    		
	}
	private static String reverse(StringBuilder s) {
		char[] c = s.toString().toCharArray();
		int n = c.length%2 == 0 ? (c.length/2) : c.length/2;
		int j = c.length - 1;
		for(int i = 0; i < n; i++){
			char x = c[i];
			c[i] = c[j];
			c[j] = x;
		}
		return new String(c);
	}
}
