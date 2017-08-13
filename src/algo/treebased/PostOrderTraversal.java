package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.Stack;

/**
 * 1. Left subtree
 * 2. Right subtree
 * 3. Root
 */
public class PostOrderTraversal {
    public static void traverseRecurssive(BinaryTree.Node tree) {
        if (tree == null) {
            return;
        }
        traverseRecurssive(tree.left);
        traverseRecurssive(tree.right);
        System.out.println(tree.data);
    }

    public static void traverseIterative(BinaryTree.Node tree) {
        Stack<BinaryTree.Node> s1 = new Stack<>();
        Stack<BinaryTree.Node> s2 = new Stack<>();
        s1.push(tree);
        while (!s1.empty()) {
            BinaryTree.Node n = s1.pop();
            s2.push(n);
            if (n.left != null) {
                s1.push(n.left);
            }
            if (n.right != null) {
                s1.push(n.right);
            }
        }
        while (!s2.empty()) {
            System.out.println(s2.pop().data);
        }
    }
}
