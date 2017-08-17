package algo.treebased;

/**
 * How to find the deepest node in a tree?
 * Related:
 * Find the height of a tree.
 * Find the longest path from the root to leaf in a tree.
 * Find the deepest left leaf of a tree.
 *
 * It shouldn’t be hard for you to realize that the root of this question is to traverse a tree.
 * More specifically, it’s a BFS (Breadth-first search) problem.
 *
 * I’ll briefly explain the details here. To BFS traverse a tree, you need to keep a queue that stores
 * nodes waiting for being visited. Initially, the queue only contains root node. So every time we pop one
 * node from the queue, after visiting this node, add all its children to the queue. By repeating this process,
 * we are traversing the tree by level order and when the queue gets empty, the last node is the deepest one.
 *
 */
public class DeepestNodeInATree {
}
