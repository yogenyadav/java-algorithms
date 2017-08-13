package datastructs.tree;

import java.util.Stack;

/**
 * https://www.tutorialspoint.com/data_structures_algorithms/tree_traversal.htm
 */
public class BinaryTree {
	public static void traversePreOrder(Node node, StringBuffer buff) {
		if (node == null) {
			return;
		}
		if (buff.length() == 0)
			buff.append(node.getData());
		else
			buff.append("=>" + node.getData());
		
		traversePreOrder(node.getLeft(), buff);
		traversePreOrder(node.getRight(), buff);
	}

	public static void iterativePreOrder(Node node, StringBuffer buff) {
		Stack<Node> s = new Stack<>();
		buff.append(node.data);
		if (node.right != null) {
			s.push(node.right);
		}
		if (node.left != null) {
			s.push(node.left);
		}
		while (!s.empty()) {
			Node n = s.pop();
			buff.append("=>" + n.data);
			if (n.right != null) {
				s.push(n.right);
			}
			if (n.left != null) {
				s.push(n.left);
			}
		}
	}

	public static void traversePostOrder(Node node, StringBuffer buff) {
		if (node == null) {
			return;
		}
		traversePostOrder(node.getLeft(), buff);
		traversePostOrder(node.getRight(), buff);
		
		if (buff.length() == 0)
			buff.append(node.getData());
		else
			buff.append("=>" + node.getData());
	}

	public static void iterativePostOrder(Node node, StringBuffer buff) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(node);
		while (!s1.empty()) {
			Node n = s1.pop();
			s2.push(n);
			if (n.left != null) {
				s1.push(n.left);
			}
			if (n.right != null) {
				s1.push(n.right);
			}
		}
		while (!s2.empty()) {
			if (buff.length() == 0)
				buff.append(s2.pop().data);
			else
				buff.append("=>" + s2.pop().data);
		}
	}

	public static void traverseInOrder(Node node, StringBuffer buff) {
		if (node == null) {
			return;
		}
		traverseInOrder(node.getLeft(), buff);
		
		if (buff.length() == 0)
			buff.append(node.getData());
		else
			buff.append("=>" + node.getData());
		
		traverseInOrder(node.getRight(), buff);
	}

	public static void iterativeInOrder(Node root, StringBuffer buff) {
		if (root == null) {
			return;
		}
		Stack<Node> s = new Stack<>();
		while (true) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				if (s.empty()) {
					break;
				}
				root = s.pop();
				if (buff.length() == 0)
					buff.append(root.data);
				else
					buff.append("=>" + root.data);
				root = root.right;
			}
		}
	}

	/**
	 * Done using a queue, this is like BFS i.e. visit all nodes in a level first then go to next level
	 *
	 */
	public static void levelOrder(Node node, StringBuffer buff) {
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

		public int getData() {
			return data;
		}
		
		public boolean isLeaf(){
			return ((left == null) && (right == null));
		}
	}

	//     1
    //    / \
    //   2   3
    //  /   / \
    // 4   5   6
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
    }
}
