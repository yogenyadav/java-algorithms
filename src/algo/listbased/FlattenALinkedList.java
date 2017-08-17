package algo.listbased;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Given a linked list, in addition to the next pointer, each node has a child pointer that can point to a
 * separate list. With the head node, flatten the list to a single-level linked list.
 *
 * Algorithm:
 * When we need to traverse a tree or graph or any data structure by level, the first thing comes to our mind should be breadth-first search (BFS) and the data structure associated with it is queue. This should be something coming to your mind in less than a second.
 *
 * 1. Start from the head node and traverse the linked list following the next pointer.
 * 2. When a node has a child node, put the child node into the queue.
 * 3. When the next pointer of the current node is null, pop the queue and repeat from the step 1 using the
 * popped node.
 *
 * 10->5->12->7->11
 * |          |
 * v          v
 * 4->20->13  17->6
 *    |   |   |
 *    v   v   v
 *    2   16  9->8
 *        |   |
 *        v   v
 *        3   19->15
 *
 * Output should be:
 * 10->5->12->7->11->4->20->13->17->6->2->16->9->8->3->19->15
 *
 * 10 and all next of 10 - level 1 (level1 print first 10->5->12->7->11)
 * 4, 17 and all their nexts - level 2 (level2 print second 4->20->13->17->6)
 * 2, 16, 9 and all their nexts - level 3 (level3 print third 2->16->9->8)
 * 3, 19 - level 4 (level4 print fourth 3->19->15)
 */
public class FlattenALinkedList {
    static List<Node> flattenList(Node head) {
        List<Node> levelOrdered = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while(!q.isEmpty()) {
            Node n = q.poll();

            while (n != null) {
                levelOrdered.add(n);
                if (n.child != null) {
                    q.offer(n.child);
                }
                n = n.next;
            }
        }
        return levelOrdered;
    }

    static class Node {
        int data;
        Node next;
        Node child;
    }

    public static void main(String[] args) {
        //level 1
        Node head = getNode(10);
        head.next = getNode(5);
        head.next.next = getNode(12);
        head.next.next.next = getNode(7);
        head.next.next.next.next = getNode(11);

        //level 2
        head.child = getNode(4);
        head.child.next = getNode(20);
        head.child.next.next = getNode(13);

        head.next.next.next.child = getNode(17);
        head.next.next.next.child.next = getNode(6);

        //level 3
        head.child.next.child = getNode(2);

        head.child.next.next.child = getNode(16);

        head.next.next.next.child.child = getNode(9);
        head.next.next.next.child.child.next = getNode(8);

        //level 4
        head.child.next.next.child.child = getNode(3);

        head.next.next.next.child.child.child = getNode(19);
        head.next.next.next.child.child.child.next = getNode(15);

        assertEquals("10->5->12->7->11->4->20->13->17->6->2->16->9->8->3->19->15",
                print(flattenList(head)));
    }

    private static String print(List<Node> nodes) {
        List<String> l = new ArrayList<>();
        for (Node n : nodes) {
            l.add(Integer.toString(n.data));
        }
        return String.join("->", l);
    }

    private static Node getNode(int data) {
        Node n =  new Node();
        n.data = data;
        return n;
    }

}
