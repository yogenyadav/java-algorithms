package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a BST (Binary search tree), find the second largest element of it.
 *
 * Make use of following facts about BST.
 * 1. BST - left is smaller than right.
 * 2. In order traversal will return all the elements in order. By altering left and right, it will return
 *    largest to smallest of smallest to largest in order.
 *
 * So,
 * 1. Do the in order traversal of the given BST.
 * 2. Keep track of the index of each visited element and when it’s the 2nd one, output as the 2nd largest element.
 *
 * You don’t need to store all the visited elements into an array and find the k-th element.
 * Instead, use a global variable i to record the index of visited elements. Inside the traversal function,
 * every time when you visit an element, just increment i by one and when i == k, output the current element.
 *
 */
public class KthLargestSmallElement {

    public static BinaryTree.Node findKthLargestElement(BinaryTree.Node node, int kth) {
        List<BinaryTree.Node> l = new ArrayList<>();
        traverseInOrder_MaxToMin(node, l);
        return l.get(kth-1);
    }

    public static BinaryTree.Node findKthSmallestElement(BinaryTree.Node node, int kth) {
        List<BinaryTree.Node> l = new ArrayList<>();
        traverseInOrder_MinToMax(node, l);
        return l.get(kth-1);
    }

    public static void traverseInOrder_MaxToMin(BinaryTree.Node node, List<BinaryTree.Node> l) {
        if (node == null) {
            return;
        }
        traverseInOrder_MaxToMin(node.right, l);
        System.out.println(node.data);
        l.add(node);
        traverseInOrder_MaxToMin(node.left, l);
    }

    public static void traverseInOrder_MinToMax(BinaryTree.Node node, List<BinaryTree.Node> l) {
        if (node == null) {
            return;
        }
        traverseInOrder_MinToMax(node.left, l);
        System.out.println(node.data);
        l.add(node);
        traverseInOrder_MinToMax(node.right, l);
    }

    public static void main(String[] args) {
        BinaryTree.Node tree = getNode(20);
        tree.left = getNode(8);
        tree.right = getNode(22);
        tree.left.left = getNode(4);
        tree.left.right = getNode(12);
        tree.right.left = getNode(21);
        tree.right.right = getNode(24);
        tree.left.right.left = getNode(10);
        tree.left.right.right = getNode(14);
        tree.right.right.left = getNode(23);
        tree.right.right.right = getNode(26);

        traverseInOrder_MaxToMin(tree, new ArrayList<>());
        traverseInOrder_MinToMax(tree, new ArrayList<>());

        System.out.println("kth largest is: " + findKthLargestElement(tree, 2).data);
        System.out.println("kth smallest is: " + findKthSmallestElement(tree, 2).data);
    }

    private static BinaryTree.Node getNode(int data) {
        return new BinaryTree.Node(data);
    }
}
