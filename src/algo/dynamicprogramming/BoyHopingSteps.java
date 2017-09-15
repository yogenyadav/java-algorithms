package algo.dynamicprogramming;

public class BoyHopingSteps {

	public static int countWaysWithoutDP(int steps){
		if(steps == 0)
			return 1;
		else if(steps < 0)
			return 0;
		return countWaysWithoutDP(steps - 1) + countWaysWithoutDP(steps - 2) + countWaysWithoutDP(steps - 3); 
	}

	public static int countWaysWithDP(int steps, int[] map){
		if(steps == 0)
			return 1;
		else if(steps < 0)
			return 0;
		else if(map[steps] > -1)
			return map[steps];
		else
			map[steps] = countWaysWithDP(steps - 1, map) +
					     countWaysWithDP(steps - 2, map) +
					     countWaysWithDP(steps - 3, map);
		return map[steps];
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println("ways by countWaysWithoutDP: " + BoyHopingSteps.countWaysWithoutDP(36));
		System.out.println("time taken by countWaysWithoutDP: " + (System.nanoTime()-start));

		start = System.nanoTime();
		System.out.println("ways by countWaysWithDP: " + BoyHopingSteps.countWaysWithDP(36, new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}));
		System.out.println("time taken by countWaysWithDP: " + (System.nanoTime()-start));
	}
}
