package datastructs.tree;

import org.junit.Test;

import datastructs.tree.BinaryTree.Node;
import static org.junit.Assert.assertEquals;

public class TestBinaryTree {

	@Test
	public void testTraversePreOrder() {
		Node n7 = new Node(60, null, null);
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, n7);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		BinaryTree.traversePreOrder(n6, buff);
		assertEquals("30=>10=>50=>60=>20=>45=>35", buff.toString());
	}

	@Test
	public void testIterativePreOrder() {
		Node n7 = new Node(60, null, null);
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, n7);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		BinaryTree.iterativePreOrder(n6, buff);
		assertEquals("30=>10=>50=>60=>20=>45=>35", buff.toString());
	}

	@Test
	public void testTraversePostOrder() {
		Node n7 = new Node(60, null, null);
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, n7);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		BinaryTree.traversePostOrder(n6, buff);
		assertEquals("50=>60=>10=>45=>35=>20=>30", buff.toString());
	}

	@Test
	public void testIterativePostOrder() {
		Node n7 = new Node(60, null, null);
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, n7);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		BinaryTree.iterativePostOrder(n6, buff);
		assertEquals("50=>60=>10=>45=>35=>20=>30", buff.toString());
	}

	@Test
	public void testTraverseInOrder() {
		Node n7 = new Node(60, null, null);
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, n7);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		BinaryTree.traverseInOrder(n6, buff);
		assertEquals("50=>10=>60=>30=>45=>20=>35", buff.toString());
	}

	@Test
	public void testIterativeInOrder() {
		Node n7 = new Node(60, null, null);
		Node n1 = new Node(50, null, null);
		Node n2 = new Node(45, null, null);
		Node n3 = new Node(35, null, null);
		Node n4 = new Node(10, n1, n7);
		Node n5 = new Node(20, n2, n3);
		Node n6 = new Node(30, n4, n5);
		StringBuffer buff = new StringBuffer();
		BinaryTree.iterativeInOrder(n6, buff);
		assertEquals("50=>10=>60=>30=>45=>20=>35", buff.toString());
	}
}
