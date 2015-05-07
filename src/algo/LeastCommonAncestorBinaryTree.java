package algo;

import java.util.Stack;

import datastructs.tree.BinaryTreeOperations.Node;

public class LeastCommonAncestorBinaryTree {

	/*
	 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	 * say give a tree and node n1 and n2, find least common ancestor of n1 and n2
	 * algo:
	 * find path from root to n1, say it is 1, 3
	 * find path from root to n2, say it is 1, 2, 4
	 * Now traverse through each path till paths starts differing from each other, return previous value
	 * In this case its 1
	 *
	 *        1
	 *        ^
	 *    2       3
	 *    ^       ^
	 * 4    5  6     7
	 */
	private static boolean pathFound = false;
	public static Node findLCA(Node root, Node n1, Node n2){
		Stack<Node> path1 = new Stack<Node>();
		Stack<Node> path2 = new Stack<Node>();
		
		pathFound = false;
		findPath(root, n1, path1);

		pathFound = false;
		findPath(root, n2, path2);
		
		Node[] p1 = path1.toArray(new Node[1]);
		Node[] p2 = path2.toArray(new Node[1]);
		for(int i = 0; i < (p1.length<=p2.length?p1.length:p2.length); i++){
			if(p1[i] != p2[i])
				return p1[i-1];
		}
		
		
		return null;
	}
	private static void findPath(Node start, Node target, Stack<Node> path) {
		path.push(start);
		if(start.data == target.data){
			pathFound = true;
			return;
		}
		if(start.left != null){
			findPath(start.left, target, path);
		}
		if(start.right != null){
			findPath(start.right, target, path);
		}
		if(!pathFound)
			path.pop();
	}

	public static void main(String[] args) {
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n2 = new Node(3, n6, n7);
		Node n3 = new Node(2, n4, n5);
		Node n1 = new Node(1, n2, n3);
		System.out.format("LCA of %s and %s is: %s", 6, 7,
				LeastCommonAncestorBinaryTree.findLCA(n1, n6, n7).data);
	}
}
