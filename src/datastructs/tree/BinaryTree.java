package datastructs.tree;

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
}
