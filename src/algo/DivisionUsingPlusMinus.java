package algo;

public class DivisionUsingPlusMinus {

	public static int divide(int n, int k){
		
		if (k == 0) System.out.println("divisor should not be 0");
		
		int remainder = Math.abs(n);
		int divisor = Math.abs(k);
		int quotient = 0;
		while(true){
			remainder = remainder - divisor;
			quotient++;
			if(remainder == 0)
				return signAdjustedQuotient(quotient, n, k);
			else if(remainder < 0)
				return signAdjustedQuotient(quotient--, n, k);
			else if(remainder < divisor)
				return signAdjustedQuotient(quotient, n, k);
		}
	}
	
	private static int signAdjustedQuotient(int q, int divisor, int dividend) {
		if((divisor > 0 && dividend > 0) || (divisor < 0 && dividend < 0)){
			return q;
		}
		return -q;
	}
	
	public static void main(String[] args){
		System.out.println(DivisionUsingPlusMinus.divide(-100, -10));
	}
}
