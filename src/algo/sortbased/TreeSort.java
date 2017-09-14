package algo.sortbased;

/**
 * A binary tree is similar to a linked list except that each node has two pointers to subsequent nodes instead of just one.
 * The value in the left child is always less than the value in the parent node, which in turn is smaller than that of the right child.
 * Thus, data in binary trees is automatically sorted. Both insertion and access are efficient at O(log n) on average.
 * Like linked lists, they are easy to transform into arrays and this is the basis for a tree-sort.
 *
 * Traverse binary tree in-order to get elements in sorted order:
 * 1. For increasing order
 * go left -> node -> go right
 *
 * 2. For decreasing order
 * go right -> node -> go left
 *
 * Time complexity = O(n log n)
 *
 */
public class TreeSort {
}
