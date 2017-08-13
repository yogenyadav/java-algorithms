package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructs.tree.BinaryTree.Node;

/* 
 * http://codercareer.blogspot.com/2011/09/no-04-paths-with-specified-sum-in.html
 * given a sum, find all the paths in binary tree with that sum
 * Algorithm:
 * Using Depth First Search technique
 * 
 * Data structures:
 * 1. Use stack to keep track of path being evaluated. Stack should have a method which returns all 
 *    entries; this is required to save when a path is found.
 * 2. Use a Hashtable to keep track if a Non Leaf Node (NL Node) is fully evaluated. For a NL Node
 *    enter value L when left tree is evaluated and R when right tree is evaluated. When NL Node has
 *    been fully evaluayed (L + R) then move on to next node.
 *    
 * Working:
 * 1. Always traverse left first then right.
 * 2. When a leaf node is reached calculate sum. Sum = sum of all the nodes in stack at this time.
 * 3. If sum = desired sum then save the path (all nodes in stack).
 * 4. When a leaf node is reached pop it from stack.
 * 4.1 parent = Pop again from stack
 * 4.2 if parent marked L then get right node and mark parent L+R
 * 4.3 if parent marked L+R then pop again
 * 
*/
public class PathsWithSpecifiedSum {
	private final static String LEFT = "L";  
	private final static String RIGHT = "R";  
	private final static String LEFT_RIGHT = "LR";  
	
	private final Node rootNode;
	
	public PathsWithSpecifiedSum(Node tree) {
		this.rootNode = tree;
	}
	
	public List<Node> getPathsWithSum(int sum) {
		List<List<Node>> pathsWithDesiredSum = new ArrayList<>();
		PushPopMax pathsEvaluating = new PushPopMax();
		Map<Node, String> nodeEvalStatus = new HashMap<>();
		
		pathsEvaluating.push(rootNode.getData());
//		while

		return null;
	}
}
