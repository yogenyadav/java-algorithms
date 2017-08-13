package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightBinaryTree {

    public static int heightRecurssive(BinaryTree.Node tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(heightRecurssive(tree.left), heightRecurssive(tree.right)) + 1;
    }

    /**
     * 1. Using queue here to add a level (entirely) to the queue.
     * 2. Then extracting the added level (entirely) and queuing up next level.
     * 3. Incrementing height as a level is entirely visited.
     *
     */
    public static int heightIterative(BinaryTree.Node tree) {
        if (tree == null) {
            return 0;
        }

        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.offer(tree);

        int height = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            //
            // visit a level entirely and queue up next level.
            //
            while (size > 0) {
                BinaryTree.Node treeNode = q.poll();
                if (treeNode.left != null) {
                    q.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.offer(treeNode.right);
                }
                size--;
            }
            height++;
        }
        return height;
    }
}
