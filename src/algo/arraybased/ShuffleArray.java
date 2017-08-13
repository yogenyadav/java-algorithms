package algo.arraybased;
import java.util.Random;

public class ShuffleArray {

	public static void main(String[] args) {
		int[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };

		shuffleArray1(solutionArray);
		for (int i = 0; i < solutionArray.length; i++) {
			System.out.print(solutionArray[i] + " ");
		}
		System.out.println();

		shuffleArray2(solutionArray);
		for (int i = 0; i < solutionArray.length; i++) {
			System.out.print(solutionArray[i] + " ");
		}
		System.out.println();
	}

	private static void shuffleArray1(int[] ar) {
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	/*
	 * XOR - outputs 1 when inputs differ 0^0=0, 1^1=0, 0^1=1, 1^0=1
	 * Property of XOR used here, swapped without temp variable:
	 * A XOR B = C then
	 * A XOR C will give B
	 * B XOR C will give A
	 */
	private static void shuffleArray2(int[] array) {
		int index;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				array[index] ^= array[i];
				array[i] ^= array[index];
				array[index] ^= array[i];
			}
		}
	}
}
