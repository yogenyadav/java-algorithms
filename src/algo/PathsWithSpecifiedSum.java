package algo;

public class PathsWithSpecifiedSum {
	// http://codercareer.blogspot.com/2011/09/no-04-paths-with-specified-sum-in.html
	// give a sum, find all the paths in binary tree with that sum
	// algo:
	// use a stack to keep path being worked on
	// keep pushing traversed node on stack
	// start from root, push root on a stack, find sum
	// if sum is equal to expected and node is leaf then print path
	// else if traverse left if left node is not null
	// else if traverse right if right node is not null
	// else pop from stack and return
	
	public static void main(String[] args) {

	}
}
