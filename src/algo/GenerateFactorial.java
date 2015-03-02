package algo;

public class GenerateFactorial {

	public static void main(String[] args) {
		long st = System.nanoTime();
		System.out.println(generateFactorialRecursive(39));
		System.out.println("time: " + (System.nanoTime() - st));

		st = System.nanoTime();
		System.out.println(generateFactorialNoRecursive(39));
		System.out.println("time: " + (System.nanoTime() - st));
	}

	private static long generateFactorialRecursive(long n) {
		if(n == 1){
			return 1;
		}
		return n * generateFactorialRecursive(n - 1);
	}

	private static long generateFactorialNoRecursive(long n) {
		long fac = 1;
		for(long i = 1; i <= n; i++){
			fac = fac * i;
		}
		return fac;
	}
}
