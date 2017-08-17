package algo.treebased;

import java.util.ArrayList;
import java.util.List;

/**
 * In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the node with the smallest
 * key greater than the key of the input node (see examples below). Given a node inputNode in a BST,
 * you’re asked to write a function findInOrderSuccessor that returns the Inorder Successor of inputNode.
 * If inputNode has no Inorder Successor, return null.
 */
public class BSTSuccessorSearch {

    static class BinarySearchTree {

        Node root;

        Node findInOrderSuccessor(Node inputNode) {
            List<Node> l = new ArrayList<>();
            traverseInOrder(root, l);
            for (int i = 0; i < l.size(); i++) {
                Node successor = null;
                if ((i + 1) < l.size()) {
                    successor = l.get((i + 1));
                }
                if (successor != null && successor.key > inputNode.key) {
                    return successor;
                }
            }
            return null;
        }

        /*
        writing a helper function which will do in order traversal of BST and create a list
        */
        static void traverseInOrder(Node treeNode, List<Node> list) {
            if (treeNode == null) {
                return;
            }
            traverseInOrder(treeNode.left, list);
            list.add(treeNode);
            traverseInOrder(treeNode.right, list);
        }


        //  Given a binary search tree and a number, inserts a new node
        //  with the given number in the correct place in the tree
        void insert(int key) {

            // 1. If the tree is empty, create the root
            if (this.root == null) {
                this.root = new Node(key);
                return;
            }

            // 2) Otherwise, create a node with the key
            //    and traverse down the tree to find where to
            //    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);

            while (currentNode != null) {
                if (key < currentNode.key) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        // Return a reference to a node in the BST by its key.
        // Use this method when you need a node to test your
        // findInOrderSuccessor method on
        Node getNodeByKey(int key) {
            Node currentNode = this.root;

            while (currentNode != null) {
                if (key == currentNode.key) {
                    return currentNode;
                }

                if (key < currentNode.key) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            return null;
        }
    }

    static class Node {

        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    /***********************************************
     * Driver program to test findInOrderSuccessor *
     ***********************************************/

    public static void main(String[] args) {

        Node test = null, succ = null;

        // Create a Binary Search Tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        // Get a reference to the node whose key is 9
        test = tree.getNodeByKey(9);

        // Find the in order successor of test
        succ = tree.findInOrderSuccessor(test);

        // Print the key of the successor node
        if (succ != null) {
            System.out.println("Inorder successor of " + test.key +
                    " is " + succ.key);
        } else {
            System.out.println("Inorder successor does not exist");
        }

        test = tree.getNodeByKey(14);

        // Find the in order successor of test
        succ = tree.findInOrderSuccessor(test);

        if (succ != null) {
            System.out.println("Inorder successor of " + test.key +
                    " is " + succ.key);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}
