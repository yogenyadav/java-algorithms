package knightmoves;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GenerateMovesSequence {

	public static void main(String[] args) throws Exception {
		int threadCount = 3; //as this is CPU intensive algo, set this to number_of_cores + 1 
		int seqLen = 10;
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		List<CalculateMoves> tasks = new ArrayList<CalculateMoves>();

		for (int row = 0; row < CalculateMoves.ROWS; row++) {
			for (int col = 0; col < CalculateMoves.COLS; col++) {
				tasks.add(new CalculateMoves(row, col, seqLen));
			}
		}

		long startTime = System.currentTimeMillis();
		List<Future<Integer>> results = executorService.invokeAll(tasks);

		int sequences = 0;

		for (Future<Integer> result : results) {
			sequences += result.get();
		}
		long timeTaken = System.currentTimeMillis() - startTime;
		
		executorService.shutdown();

		System.out.println("total number of sequences: " + sequences);
		System.out.println("time taken: " + timeTaken + "ms");
	}
}
