package algo.listbased;

import java.util.Optional;

public class DetectAndBreakLoop {

    /**
     * http://www.geeksforgeeks.org/?p=112
     * 3 methods:
     * 1. Use Hashing
     * 2. Mark Visited Nodes
     * 3. Floyd’s Cycle-Finding Algorithm
     * This is the fastest method. Traverse linked list using two pointers.
     * Move one pointer by one and other pointer by two.  If these pointers meet at some node then there is a loop.
     * If pointers do not meet then linked list doesn’t have loop.
     */
    public Optional<Node> detectLoop(Node head) {

        // if loop exists then return the loop node.
        return Optional.empty();
    }

    /**
     * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
     *
     * 1. Use 2 pointers headPtr starts at head and loopPtr starts at loopNode
     * 2. For each headPtr.next, check if any of the loopPtr.next == headPtr.next
     * 2.1 If true then headPtr.next is the beginning of loop and loopPtr.next is end of loop
     * 2.1.1 Make loopPtr.next = null
     */
    public void breakLoop(Node head, Node loopNode) {

    }
}
