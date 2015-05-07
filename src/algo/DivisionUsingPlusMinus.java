package algo;

public class DivisionUsingPlusMinus {

	public static int divide(int n, int k){
		
		assert n > 0: "n should be greater than 0";
		assert k > 0: "k should be greater than 0";
		
		int remainder = n;
		int quotient = 0;
		while(true){
			remainder = remainder - k;
			quotient++;
			if(remainder == 0)
				return quotient;
			else if(remainder < 0)
				return quotient--;
			else if(remainder < k)
				return quotient;
		}
	}
	
	public static void main(String[] args){
		System.out.println(DivisionUsingPlusMinus.divide(-100, 10));
	}
}
