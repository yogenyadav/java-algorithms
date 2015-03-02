import java.util.BitSet;


public class CountBits {

	public static void main(String[] args) {
		long st = System.nanoTime();
		System.out.println(countBits1(67598437) + "count, time: " + (System.nanoTime() - st));
		st = System.nanoTime();
		System.out.println(countBits4(67598437) + "count, time: " + (System.nanoTime() - st));
		st = System.nanoTime();
		System.out.println(countBits2(67598437) + "count, time: " + (System.nanoTime() - st));
		st = System.nanoTime();
		System.out.println(countBits3(67598437) + "count, time: " + (System.nanoTime() - st));
	}
	private static int countBits1(int n){
		return Integer.bitCount(n);
	}
	//using Hamming Weight algorithm
	private static int countBits2(int n){
		int m1 = 0x55555555; //1 zero, 1 one
		int m2 = 0x33333333; //2 zero, 2 one
		int m3 = 0x0F0F0F0F; //4 zero, 4 one
		int m4 = 0x00FF00FF; //8 zero, 8 one
		int m5 = 0x0000FFFF; //16 zero, 16 one
		
		n = (n & m1) + ((n >> 1) & m1);
		n = (n & m2) + ((n >> 2) & m2);
		n = (n & m3) + ((n >> 4) & m3);
		n = (n & m4) + ((n >> 8) & m4);
		n = (n & m5) + ((n >> 16) & m5);
		return n;
	}
	private static int countBits3(int n){
		int m = 0x00000001;
		int count = 0;
		for(int i=0; i<32; i++){
			if(((n >> i) & m) == 1)
				count++;
		}
		return count;
	}
	// Copied from Integer.bitCount()
	private static int countBits4(int i) {
	    i = i - ((i >>> 1) & 0x55555555);
	    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
	    i = (i + (i >>> 4)) & 0x0f0f0f0f;
	    i = i + (i >>> 8);
	    i = i + (i >>> 16);
	    return i & 0x3f;
	}
}
