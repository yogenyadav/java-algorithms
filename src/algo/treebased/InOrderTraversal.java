package algo.treebased;

import datastructs.tree.BinaryTree;

/**
 * 1. Left subtree
 * 2. Root
 * 3. Right subtree
 */
public class InOrderTraversal {
    public static void traverseRecurssive(BinaryTree.Node tree) {
        if (tree == null) {
            return;
        }
        traverseRecurssive(tree.left);
        System.out.println(tree.data);
        traverseRecurssive(tree.right);
    }

    public static void traverseIterative(BinaryTree.Node tree) {

    }
}
