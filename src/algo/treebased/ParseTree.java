package algo.treebased;

import datastructs.tree.BinaryTree;

import java.util.Stack;

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

    /**
     * Parse the expression and follow following rules
     * 1. if char = c
     *
     */
    public static Node treeFromExpression(String expr) {
        Stack<Node> s = new Stack<>();
        Node currNode = new Node();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            switch (c) {
                case '(':
                    currNode.left = new Node();
                    s.push(currNode);
                    currNode = currNode.left;
                    break;
                case ')':
                    s.pop();
                    if (!s.isEmpty()) {
                        currNode = s.peek();
                    }
                    break;
                case '+':
                    currNode.operator = String.valueOf('+');
                    currNode.right = new Node();
                    currNode = currNode.right;
                    break;
                case '-':
                    currNode.operator = String.valueOf('-');
                    currNode.right = new Node();
                    currNode = currNode.right;
                    break;
                case '*':
                    currNode.operator = String.valueOf('*');
                    currNode.right = new Node();
                    currNode = currNode.right;
                    break;
                case '/':
                    currNode.operator = String.valueOf('/');
                    currNode.right = new Node();
                    currNode = currNode.right;
                    break;
                default:
                    // an operand is seen
                    currNode.operand = Integer.valueOf(String.valueOf(c));
                    currNode = s.peek();
                    break;
            }
        }
        return currNode;
    }

    /**
     * Post order traversal lets evaluate expression tree.
     *
     */
    public static Float evaluateExpression(Node treeNode) {
        if (treeNode == null) {
            return null;
        }
        Float res1 = evaluateExpression(treeNode.left);
        Float res2 = evaluateExpression(treeNode.right);
        Float res = null;
        if (res1 != null && res2 != null) {
          String operator = treeNode.operator;
          if ("+".equals(operator)) {
              res = res1 + res2;
          } else if ("-".equals(operator)) {
              res = res1 - res2;
          } else if ("*".equals(operator)) {
              res = res1 * res2;
          } else if ("/".equals(operator)) {
              res = res1 / res2;
          }
        } else {
            res = (float) treeNode.operand;
        }
        return res;
    }

    /**
     * In Order traversal provides expression from tree.
     *
     */
    public static void expressionFromTree(Node treeNode, StringBuilder sb) {
        if (treeNode == null) {
            return;
        }
        sb.append("(");
        expressionFromTree(treeNode.left, sb);
        if (treeNode.operator != null) {
            sb.append(treeNode.operator);
        } else {
            sb.append(treeNode.operand);
        }
        expressionFromTree(treeNode.right, sb);
        sb.append(")");
    }

    public static class Node {
        public String operator;
        public int operand;
        public Node left;
        public Node right;
    }

    public static void main(String[] args) {
        //(1+(2*(4+5)))
        Node exprTree = treeFromExpression("(1+(2*(4+5)))");
        System.out.println(exprTree);

        StringBuilder sb = new StringBuilder();
        expressionFromTree(exprTree, sb);
        System.out.println(sb);

        Float res = evaluateExpression(exprTree);
        System.out.println(res);

        // ((1+2)+(2*5))
        exprTree = treeFromExpression("((1+2)+(2*5))");
        System.out.println(exprTree);

        res = evaluateExpression(exprTree);
        System.out.println(res);

        sb = new StringBuilder();
        expressionFromTree(exprTree, sb);
        System.out.println(sb);
    }
}
