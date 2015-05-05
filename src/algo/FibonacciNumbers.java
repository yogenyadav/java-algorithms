package algo;

public class FibonacciNumbers {

	public static void main(String[] args) {
		int febCount = 15;
		int[] feb = new int[febCount];
		feb[0] = 0;
		feb[1] = 1;
		for (int i = 2; i < febCount; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		StringBuffer fibBuff = new StringBuffer();
		for (int i = 0; i < febCount; i++) {
			fibBuff.append(feb[i] + ", ");
		}
		System.out.println(fibBuff);
		
		fibBuff.delete(0, fibBuff.length());
		for(int i=0; i<15; i++)
			fibBuff.append(fibonacciNumber1(i) + ", ");
		System.out.println(fibBuff);
	}

	/**
	 * generates fibonacci numbers 
	 * but performance degrades drastically quadratic when n is high 
	 */
	public static int fibonacciNumber1(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return (fibonacciNumber1(n - 1) + fibonacciNumber1(n - 2));
	}
	/**
	 * uses DP to solve problem of fibonacciNumber1
	 * saves calculated values in an array, gives O(n) performance but uses O(n) space 
	 */
	//TODO
	public static int fibonacciNumber2(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return (fibonacciNumber1(n - 1) + fibonacciNumber1(n - 2));
	}
	/**
	 * improvement over fibonacciNumber2, saves only last 2 
	 * calculated values, gives O(n) performance and uses O(1) space 
	 */
	//TODO
	public static int fibonacciNumber3(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return (fibonacciNumber1(n - 1) + fibonacciNumber1(n - 2));
	}
}
