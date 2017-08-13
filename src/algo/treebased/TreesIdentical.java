package algo.treebased;

import datastructs.tree.BinaryTree;

public class TreesIdentical {
    public static boolean areIdenticalRecursive(BinaryTree.Node tree1, BinaryTree.Node tree2) {

        if (tree1 == null || tree2 == null) {
            return false;
        }

        return tree1.data == tree2.data
                && areIdenticalRecursive(tree1.left, tree2.left)
                && areIdenticalRecursive(tree1.right, tree2.right);
    }

    public static boolean areIdenticalIterative(BinaryTree.Node tree1, BinaryTree.Node tree2) {
        return false;
    }
}
