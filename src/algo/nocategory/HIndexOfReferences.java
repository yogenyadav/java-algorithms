package algo.nocategory;

import java.util.PriorityQueue;

/**
 * h-index reflects both the number of publications and the number of citations per publication.
 * if we have a researcher with 5 publications A, B, C, D, and E with 10, 8, 5, 4, and 3 citations, respectively,
 * the h index is equal to 4 because the 4th publication has 4 citations and the 5th has only 3.
 * Lets say citations are in a array with start index of 1
 * [10, 8, 5, 4, 3], at index=4, value is 4
 * Index represents number of papers = 4
 * Value at index therefore number of citations = 4
 * >>there are 4 papers which have 4 or more citations
 *
 * if the same publications have 25, 8, 5, 3, and 3, then the index is 3 because the fourth paper has only 3 citations.'
 * [25, 8, 5, 3, 3]
 * index=3, therefore number of papers = 3
 * value=5, therefore number of citations = 5
 * >>there are 3 papers which have 5 or more citations.
 *
 * Algorithm:
 * 1. sort citations in reverse order, lets use a maxHeap
 * 2. start index at 1
 * 3. for each take from heap increment index
 *      stop when heap value < index
 * 4. return previous index and value.
 * >>index represents the h-index
 *
 */
public class HIndexOfReferences {

    public static int hIndex(int[] citations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
           if (o1 < o2) {
               return 1;
           } else if (o1 > o2) {
               return -1;
           }
           return 0;
        });

        for (int i = 0; i < citations.length; i++) {
            maxHeap.offer(citations[i]);
        }

        int idx = 0;
        int before = 1;
        while (maxHeap.size() != 0) {
            idx++;
            int value = maxHeap.poll();
            if (value < idx) {
                return before;
            }
            before = idx;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(HIndexOfReferences.hIndex(new int[]{25, 8, 5, 3, 3}));
        System.out.println(HIndexOfReferences.hIndex(new int[]{10, 8, 5, 4, 3}));
        System.out.println(HIndexOfReferences.hIndex(new int[]{20, 30, 40, 50, 7})); //what should be hindex in this case??
    }
}
