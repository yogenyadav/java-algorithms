package datastructs.tree;

import java.util.Stack;
import java.util.StringTokenizer;

public class BinaryTreeOperations {
	public static void preOrderPersist(Node node, StringBuffer buff) {
		if (node == null) {
			buff.append(",!");
			return;
		}
		if (buff.length() == 0)
			buff.append(node.getData());
		else
			buff.append("," + node.getData());
		preOrderPersist(node.getLeft(), buff);
		preOrderPersist(node.getRight(), buff);
	}

	public static Node makeTree(String str) {
		Stack<String> stack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(str, ",");
		while (st.hasMoreTokens()) {
			stack.push(st.nextToken());
		}
		System.out.println(stack);
		int markerCount = 0;
		while (!stack.isEmpty()) {
			String element = stack.pop();
			if ("!".equals(element)) {
				markerCount++;
			} else {
				if (markerCount == 2) {
					// its a leaf node
					markerCount = 0;
					Node n = new Node(Integer.valueOf(element));
				} else if (markerCount == 3) {
					// parent has no right node
					Node n = new Node(Integer.valueOf(element));
				}
			}
		}
		return null;
	}

	public static class Node{
		public int data;
		public Node left;
		public Node right;
		
		public Node(int i, Node left, Node right) {
			data = i;
			this.left = left;
			this.right = right;
		}
		public Node(int i) {
			this(i, null, null);
		}

		public Node(Integer d) {
			data = d;
		}

		public Node getRight() {
			return right;
		}

		public Node getLeft() {
			return left;
		}

		public Object getData() {
			return data;
		}
		
	}
	public static void main(String[] args) {
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, null);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		preOrderPersist(n6, buff);
		System.out.println(buff);
		makeTree(buff.toString());
	}
}
