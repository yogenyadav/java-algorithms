package algo.treebased;

//               30
//           /       \
//          /         \
//         /           \
//       10             20
//     /    \         /    \
//   50      60     45      35
//  /  \    /  \   /   \   /  \
// 12  14  31  23  34  16 43  29

import datastructs.tree.BinaryTree;

import java.util.List;

public class FindLeastCommonAncestor {

    /**
     * To find least commonn ancestor of 2 node
     * 1. find path from root to node 1
     * 2. find path from root to node 2
     * 3. iterate the 2 path simultaneously until they diverge
     * Example LCA of 43 and 45
     * 1. path to 45: 30-20-45
     * 2. path to 43: 30-20-35-43
     * Paths start diverging after 20, so 20 is LCA
     *
     */

    public static BinaryTree.Node findLCA(BinaryTree.Node root, BinaryTree.Node node1, BinaryTree.Node node2) {
        List<BinaryTree.Node> path1 = FindPathRootToNode.findPath(root, node1);
        List<BinaryTree.Node> path2 = FindPathRootToNode.findPath(root, node2);
        int minSize = Math.min(path1.size(), path2.size());
        for (int i = 0; i < minSize; i++) {
            if (path1.get(i).data != path2.get(i).data) {
                return path1.get(i-1);
            }
        }
        return null;
    }
}
