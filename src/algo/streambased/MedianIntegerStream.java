package algo.streambased;

import java.util.PriorityQueue;

/**
 * Algorithm keeps the numbers sorted as they are seen in the stream. Think about a number line on which streaming
 * numbers are dropped. Median is the number in the middle on the number line.
 *
 * maxHeap represents numbers on left side of median.
 * minHeap represents numbers on right side of median.
 *
 */
public class MedianIntegerStream {

    //default: min is at top
    //minHeap is used for the right side of median
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //max at top
    //maxHeap is used for the left side of the median on number line
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
        if (o1 < o2) return 1;
        else if (o1 > o2) return -1;
        return 0;
    });

    private int currentMedian = 0;

    public int newStreamElement(int e) {
        if(minHeap.peek() == null && maxHeap.peek() == null) {
            minHeap.offer(e);

        } else if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(e);

        }else if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(e);

        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(e);
        }

        rebalanceHeaps();
        calcMedian();
        return currentMedian;
    }

    private void rebalanceHeaps() {
        if (minHeap.peek() == null || maxHeap.peek() == null) {
            return;
        }

        if (maxHeap.peek() > minHeap.peek()) {
            //swap
            int tmp = minHeap.poll();
            minHeap.offer(maxHeap.poll()); //balance the heaps, so that they are of same size
            maxHeap.offer(tmp);
        }
    }

    private void calcMedian() {
        if (minHeap.size() + maxHeap.size() == 1) {
            currentMedian = minHeap.peek();
            return;
        }

        if (minHeap.size() == maxHeap.size()) {
            currentMedian = (minHeap.peek() + maxHeap.peek()) / 2;
        }else if (minHeap.size() > maxHeap.size()) {
            currentMedian = minHeap.peek();
        }else {
            currentMedian = maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1 < 02) return 1;
            else if (o1 > 02) return -1;
            return 0;
        });
        minHeap.offer(10);
        minHeap.offer(11);
        minHeap.offer(12);
        minHeap.offer(9);
        minHeap.offer(8);
        minHeap.offer(13);

//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());
//        System.out.println(minHeap.poll());

        MedianIntegerStream m = new MedianIntegerStream();
        System.out.println(m.newStreamElement(10));
        System.out.println(m.newStreamElement(20));
        System.out.println(m.newStreamElement(30));
        System.out.println(m.newStreamElement(7));
        System.out.println(m.newStreamElement(5));
        System.out.println(m.newStreamElement(15));
        System.out.println(m.newStreamElement(25));
        System.out.println(m.newStreamElement(40));
        System.out.println(m.newStreamElement(35));
        System.out.println(m.newStreamElement(17));
        System.out.println(m.newStreamElement(21));
        System.out.println(m.newStreamElement(3));
    }
}
