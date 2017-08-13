package algo.treebased;

import datastructs.tree.BinaryTree;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

//     30
//     / \
//   10   20
//  / \   / \
// 50 60 45 35
public class TestFindPath {
    @Test
    public void testFindPath() {
        BinaryTree.Node n1 = getNode(30);
        n1.left = getNode(10);
        n1.right = getNode(20);
        n1.left.left = getNode(50);
        n1.left.right = getNode(60);
        n1.right.left = getNode(45);
        n1.right.right = getNode(35);

        // path should be 30->10->60
        List<BinaryTree.Node> path = FindPath.findPath(n1, getNode(60));
        assertTrue(path.get(0).data == 30);
        assertTrue(path.get(1).data == 10);
        assertTrue(path.get(2).data == 60);

        // path should be 30->20->35
        path = FindPath.findPath(n1, getNode(35));
        assertTrue(path.get(0).data == 30);
        assertTrue(path.get(1).data == 20);
        assertTrue(path.get(2).data == 35);

        // path should be 30->20->45
        path = FindPath.findPath(n1, getNode(45));
        assertTrue(path.get(0).data == 30);
        assertTrue(path.get(1).data == 20);
        assertTrue(path.get(2).data == 45);

        // path should be 30->20
        path = FindPath.findPath(n1, getNode(20));
        assertTrue(path.get(0).data == 30);
        assertTrue(path.get(1).data == 20);

        // path should be 30
        path = FindPath.findPath(n1, getNode(30));
        assertTrue(path.get(0).data == 30);
    }

    private BinaryTree.Node getNode(int data) {
        return new BinaryTree.Node(data);
    }
}
