package algo.stacksqueues;

import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> inbox = new Stack<Integer>();
    private Stack<Integer> outbox = new Stack<Integer>();

    public void queue(Integer item) {
        inbox.push(item);
    }

    public Integer dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
               outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
}
