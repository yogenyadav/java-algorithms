package algo.arraybased;

import java.util.Arrays;

public class ArrayOfProducts {
	/**
	 * This is dynamic programming technique
	 */
	public static int[] arrayOfProducts(int[] arrayOfNumbers){
		int[] p1 = new int[arrayOfNumbers.length];
		for(int i=0; i<arrayOfNumbers.length; i++){
			if(i == 0)
				p1[i] = 1;
			else{
				p1[i] = p1[i-1] * arrayOfNumbers[i-1];
			}
		}
		int[] p2 = new int[arrayOfNumbers.length];
		int i = arrayOfNumbers.length -1;
		while(i>-1){
			if(i == (arrayOfNumbers.length - 1))
				p2[i] = 1;
			else{
				p2[i] = p2[i+1] * arrayOfNumbers[i+1];
			}
			i--;
		}
		int[] p3 = new int[arrayOfNumbers.length];
		for(int j=0; j<arrayOfNumbers.length; j++){
			p3[j] = p1[j] * p2[j];
		}
		return p3;
	}
	
	public static void main(String[] args) {
		int[] arrayOfNumbers = new int[]{2,3,4,5,6,7};
		int[] products = ArrayOfProducts.arrayOfProducts(arrayOfNumbers);
		System.out.println(Arrays.toString(products));
	}
}
