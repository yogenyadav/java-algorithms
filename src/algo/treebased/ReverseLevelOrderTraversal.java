package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Prints one level at a time
 * 1. Leaf level
 * 2. Level before
 * 3. Level before
 * ...so on
 * ....Root in the end
 *
 * Use a queue to traverse tree level by level from top to bottom.
 * While traversing from level, push nodes in each level into a stack.
 *
 * As bottom nodes go into stack in the end they are popped first as nature stack is LIFO.
 *
 */
public class ReverseLevelOrderTraversal {
    public static void traverse(BinaryTree.Node tree) {
        Queue<BinaryTree.Node> q = new LinkedList();
        Stack<BinaryTree.Node> s = new Stack<>();

        q.offer(tree);
        while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                BinaryTree.Node treeNode = q.poll();
                s.push(treeNode);
                if (treeNode.left != null) {
                    q.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.offer(treeNode.right);
                }
                size--;
            }
        }
        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }
}
