package imperative.to.functional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * deoderizing inner classes.
 *
 */
public class Example1 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		/*
		 * imperative style
		 */
		for(int i = 0; i < 10; i++) {
			final int index = i;
			service.submit(new Runnable () {
				@Override
				public void run() {
					System.out.println("running task " + index);
				}
			});
		}
		
		/*
		 * functional style
		 */
		//
		// Runnable is a functional interface hence lambda function can be passed
		//
		IntStream
		.range(0, 10)
		.forEach(i -> 
			service.submit(() -> System.out.println("running task " + i)));
	
		service.shutdown();
	}
}
