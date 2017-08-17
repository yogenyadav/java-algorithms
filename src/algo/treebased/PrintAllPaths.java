package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Given a binary tree, print all of the paths from the root to leaf nodes.
 * Recursive and Iterative.
 *
 */
public class PrintAllPaths {

    public static void printAllPathsRecursive(BinaryTree.Node node, BinaryTree.Node[] path, int pathLen) {
        if (node == null) {
            return;
        }
        path[pathLen] = node;
        pathLen++;
        if (node.left == null && node.right == null) {
            printPath(path, pathLen);
        } else {
            printAllPathsRecursive(node.left, path, pathLen);
            printAllPathsRecursive(node.right, path, pathLen);
        }
    }

    public static void printAllPathsIterative(BinaryTree.Node node) {
    }

    private static void printPath(BinaryTree.Node[] path, int pathLen) {
        int i;
        for (i = 0; i < pathLen; i++) {
            System.out.print(path[i].data + " ");
        }
        System.out.println("");
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

        printAllPathsRecursive(tree, new BinaryTree.Node[1000], 0);
    }

    private static BinaryTree.Node getNode(int data) {
        return new BinaryTree.Node(data);
    }
}
