package imperative.to.functional;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Using Internal versus External Iterators.
 * - specialized functions
 * - function composition
 * - infinite streams
 * - lazy evaluation
 */
public class Example2 {

	public static void main(String[] args) {
		/*
		 * imperative style
		 */
//		List<Double> sqrtOffFirst100Primes = new ArrayList<>();
//		
//		int idx = 1;
//		while(sqrtOffFirst100Primes.size() < 100) {
//			if (isPrime(idx)) {
//				sqrtOffFirst100Primes.add(Math.sqrt(idx));
//			}
//			idx++;
//		}
		/*
		 * functional style
		 */
		//
		// Stream.iterator - using internal iterator instead of external
		// iterator, map, limit are intermediate functions these are lazy i.e. they do not
		// produce any values until asked
		// collect is a terminal function
		//
		// Streams have intermediate functions and terminal functions
		// Intermediate function don't do any work they just accumulate 
		// Intermediate functions execute only when a terminal function is called
		//
		
		// A good code reads like a story not like a puzzle

		// Function composition
		List<Double> sqrtOffFirst100Primes = 
		    Stream
			.iterate(1, e -> e + 1) //creates an infinite series 1,2,3...
			.filter(Example2::isPrime) //lazy
			.map(Double::valueOf) //lazy
			.map(Math::sqrt) //lazy
			.limit(100) //lazy
			.collect(toList()); //terminal, triggers execution
//		System.out.println("done");
		
		System.out.println(String.format("computed %d values, first is %g, last is %g",
				sqrtOffFirst100Primes.size(),
				sqrtOffFirst100Primes.get(0),
				sqrtOffFirst100Primes.get((sqrtOffFirst100Primes.size() - 1))));
	}

	public static boolean isPrime(int n) {
		/*
		 * imperative style
		 */
//		boolean divisible = false;
//		for (int i = 2; i < n; i++) {
//			if (n % i == 0) {
//				divisible = true;
//				break;
//			}
//		}
//		return n > 1 && !divisible;
		
		/*
		 * functional style
		 */
//		System.out.println("called....");
		return n > 1 && IntStream.range(2, n).noneMatch(i -> n % i == 0);
	}
}
