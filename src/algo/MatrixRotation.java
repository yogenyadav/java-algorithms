package algo;
import java.util.Arrays;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] m = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		System.out.println("m: " + Arrays.toString(m));
		
//		(i,j) > (j,N-1-i)
//		0,0 > 0,2 - 0, 3-1-0 - 0,2 : (0,0) goes to (0,2)
//		0,1 > 1,2 - 1, 3-1-0 - 1,2 : (0,1) goes to (1,2)
//		0,2 > 2,2 - 2, 3-1-0 - 2,2 : (0,2) goes to (2,2)
//		
//		2,0 > 0,0 - 0, 3-1-2 - 0,0 : (2,0) goes to (0,0)
//		2,1 > 1,0 - 1, 3-1-2 - 1,0 : (2,1) goes to (1,0)
//		2,2 > 2,0 - 2, 3-1-2 - 2,0 : (2,2) goes to (2,0)
//		before rotation
//		[[1, 2, 3], 
//		 [4, 5, 6], 
//		 [7, 8, 9]]
//		after clockwise rotation
//		[[7, 4, 1], 
//		 [8, 5, 2], 
//		 [9, 6, 3]]
		
		//(r, c) goes to location (c, R-1-r)
		int[][] mr90 = new int[3][3];
		int N = 3;
		for(int r = 0; r < 3; r++){
			for(int c = 0; c < 3; c++){
				//mr90[r][c] = m[c][N-1-r];
				mr90[c][N-1-r] = m[r][c];
			}
		}
		System.out.println("mr90: " + Arrays.toString(mr90));
	}

}
