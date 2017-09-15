package algo.searchbased;


import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class BinarySearch {

	public static boolean search(int[] sortedArrayOfInts, int intToSearchFor){
		int low = 0;
		int high = sortedArrayOfInts.length - 1;
		
		while(low <= high){
			int mid = low + (high - low)/2;
			System.out.println("low: " + low);
			System.out.println("high: " + high);
			System.out.println("mid: " + mid);
			if(intToSearchFor < sortedArrayOfInts[mid]){ 
				high = mid - 1;
			}else if(intToSearchFor > sortedArrayOfInts[mid]){ 
				low = mid + 1;
			}else
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] sortedArrayOfInts = new int[]{4,6,8,11,13,14,23,29,33,43,45,56,63,78,79,89,90,93,96,98, 101, 104, 109, 110, 201, 202, 207};
		StopWatch s = new StopWatch();
		s.start();
		boolean f = BinarySearch.search(sortedArrayOfInts, 89);
		s.stop();
		System.out.println("time: + " + s.getTime(TimeUnit.MILLISECONDS) + ", " + f);
	}
}
