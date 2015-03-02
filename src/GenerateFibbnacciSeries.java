
public class GenerateFibbnacciSeries {

	public static void main(String[] args) {
		System.out.println(nThFibnacciNumber(10));
	}

	private static int nThFibnacciNumber(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return nThFibnacciNumber(n-1) + nThFibnacciNumber(n-2);
	}
	//0 1 1 2 3 5 8
	
	/*
	 * Also solve it using DP for efficiency
	 */
}
