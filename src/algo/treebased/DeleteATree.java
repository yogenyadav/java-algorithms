package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteATree {
    /**
     * Uses post order method to delete a tree
     * 1. delete all of the left subtrees then
     * 2. delete all of the right subtrees then
     * 3. delete the root
     */
    public static void deleteTreeRecurssive(BinaryTree.Node tree) {
        if (tree == null) {
            return;
        }
        deleteTreeRecurssive(tree.left);
        tree.left = null; // using null reference, to be garbage collected
        deleteTreeRecurssive(tree.right);
        tree.right = null; // using null reference, to be garbage collected
    }

    public static void deleteTreeIterative(BinaryTree.Node tree) {
        if (tree == null) {
            return;
        }
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.offer(tree);
        while (!q.isEmpty()) {
            BinaryTree.Node treeNode = q.poll();
            if (treeNode.left != null) {
                q.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                q.offer(treeNode.right);
            }
            treeNode.left = null;
            treeNode.right = null;
        }
    }
}
