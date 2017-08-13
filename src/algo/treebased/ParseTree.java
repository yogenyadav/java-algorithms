package algo.treebased;

import datastructs.tree.BinaryTree;

/**
 * This is an example of parse trees. The example builds a parse tree from math expression.
 * Evaluates expression using parse tree, uses post-order traversal method.
 * And creates expression back from parse tree, uses in-order traversal method.
 *
 * Other examples of parse trees
 * - DOM (html page)
 * - Directory structure
 * - Language sentence
 *
 */
public class ParseTree {
    public BinaryTree.Node treeFromExpression(String expr) {
        return null;
    }

    /**
     * Post order traversal lets evaluate expression tree.
     *
     */
    public float evaluateExpression(BinaryTree.Node treeNode) {
        return 1F;
    }

    /**
     * In Order traversal provides expression from tree.
     *
     */
    public String expressionFromTree(BinaryTree.Node treeNode) {
        return null;
    }
}
