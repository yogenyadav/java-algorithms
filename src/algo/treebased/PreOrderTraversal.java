package algo.treebased;

import datastructs.tree.BinaryTree;

/**
 * 1. Root
 * 2. Left subtree
 * 3. Right subtree
 */
public class PreOrderTraversal {
    public static void traverseRecurssive(BinaryTree.Node tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.data);
        traverseRecurssive(tree.left);
        traverseRecurssive(tree.right);
    }

    public static void traverseIterative(BinaryTree.Node tree) {

    }
}
