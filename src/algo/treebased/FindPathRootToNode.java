package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPathRootToNode {
    /**
     * find path from root to a node.
     *
     */
    public static List<BinaryTree.Node> findPath(BinaryTree.Node root, BinaryTree.Node toNode) {
        Stack<BinaryTree.Node> stack = new Stack<>();
        findPath(root, toNode, stack);
        List<BinaryTree.Node> path = new ArrayList<>();
        while (!stack.empty()) {
            path.add(stack.pop());
        }
        return path;
    }

    public static boolean findPath(BinaryTree.Node node, BinaryTree.Node toNode, Stack<BinaryTree.Node> path) {
        if (node == null) {
            return false;
        }
        if (node.data == toNode.data) {
            path.push(node);
            return true;
        }
        if (findPath(node.left, toNode, path)) {
            path.push(node);
            return true;
        }
        if (findPath(node.right, toNode, path)) {
            path.push(node);
            return true;
        }
        return false;
    }
}
