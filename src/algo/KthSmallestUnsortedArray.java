package algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KthSmallestUnsortedArray {
	/*
	 * uses quick select algorithm
	 */
	public static int usingQuickSelect(Integer[] a, int k){
		Random rand = new Random();
		int r = rand.nextInt(a.length);
		
		int pivot = a[r];
		List<Integer> al1 = new ArrayList<Integer>();
		List<Integer> al2 = new ArrayList<Integer>();
		for(int i=0; i<a.length; i++){
			if(a[i] < pivot){
				al1.add(a[i]);
			}else if(a[i] > pivot){
				al2.add(a[i]);
			}
		}
		
		Integer[] a1 = al1.toArray(new Integer[0]);
		Integer[] a2 = al2.toArray(new Integer[0]);
		if(k <= a1.length){
			return usingQuickSelect(a1, k);
		}else if(k > (a.length - a2.length)){
			return usingQuickSelect(a2, k - (a.length - a2.length));
		}else{
			return pivot;
		}
	}
	
	/*
	 * uses min heap
	 */
	public static int usingMinHeap(Integer[] a, int k){
		return 1;
	}
	
	/*
	 * by just traversing array
	 */
	public static int byTraversing(Integer[] a, int k){
		return 1;
	}

	public static void main(String[] args){
		/* 87 86 65 64 63 55 54 51 45 34 32 23 10 8*/
		Integer[] a = new Integer[]{10, 8, 51, 63, 55, 32, 45, 86, 23, 64, 34, 87, 54, 65};
		System.out.println("3rd largest " + KthSmallestUnsortedArray.usingQuickSelect(a, 3));
	}
}
