package algo.treebased;

import datastructs.tree.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

//               30
//           /       \
//          /         \
//         /           \
//       10             20
//     /    \         /    \
//   50      60     45      35
//  /  \    /  \   /   \   /  \
// 12  14  31  23  34  16 43  29
public class TestFindLeastCommonAncestor {

    @Test
    public void testFindLCA() {
        BinaryTree.Node n1 = getNode(30);
        n1.left = getNode(10);
        n1.right = getNode(20);
        n1.left.left = getNode(50);
        n1.left.right = getNode(60);
        n1.right.left = getNode(45);
        n1.right.right = getNode(35);
        n1.left.left.left = getNode(12);
        n1.left.left.right = getNode(14);
        n1.left.right.left = getNode(31);
        n1.left.right.right = getNode(23);
        n1.right.left.left = getNode(34);
        n1.right.left.right = getNode(16);
        n1.right.right.left = getNode(43);
        n1.right.right.right = getNode(29);

        BinaryTree.Node lca = FindLeastCommonAncestor.findLCA(n1, getNode(45), getNode(43));
        assertTrue(lca.data == 20);

        lca = FindLeastCommonAncestor.findLCA(n1, getNode(34), getNode(16));
        assertTrue(lca.data == 45);

        lca = FindLeastCommonAncestor.findLCA(n1, getNode(23), getNode(16));
        assertTrue(lca.data == 30);

        lca = FindLeastCommonAncestor.findLCA(n1, getNode(12), getNode(60));
        assertTrue(lca.data == 10);

        lca = FindLeastCommonAncestor.findLCA(n1, getNode(12), getNode(90));
        assertTrue(lca == null);
    }

    private BinaryTree.Node getNode(int data) {
        return new BinaryTree.Node(data);
    }
}
