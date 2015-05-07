package algo;

public class SumOfIntegerDigits {

	public static void main(String[] args) {
		int i = addDigitsWORecursion(345678);
		System.out.println("i: " + i);
		
		int j = addDigitsWRecursion(345678);
		System.out.println("j: " + j);
	}

	private static int addDigitsWORecursion(int i) {
		int t = 0;
		int a = 0;
		while(true){
			a = i % 10;
			t = t+a;
			i = i / 10;
			if(i == 0)
				break;
		}
		return t;
	}
	private static int addDigitsWRecursion(int i) {
		if(i == 0)
			return 0;
		return i%10 + addDigitsWRecursion(i/10);
	}
}
