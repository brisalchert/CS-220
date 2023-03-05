//----------------------------------------------------------------------------------------------------------------------
//  PriorityQueueTest.java              Author: Brian Salchert
//
//  Driver class for the UnsortedPriorityQueue class.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;
import java.util.Comparator;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                }
                else {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                }

                return 1;
            }
        };

        UnsortedPriorityQueue<Integer,Integer> unsortedPriorityQueue = new UnsortedPriorityQueue<Integer,Integer>();
        SortedPriorityQueue<Integer,Integer> sortedPriorityQueue = new SortedPriorityQueue<Integer,Integer>();

        unsortedPriorityQueue.insert(3, 4);
        unsortedPriorityQueue.insert(2, 5);
        unsortedPriorityQueue.insert(4, 1);

        System.out.println(unsortedPriorityQueue.removeMin());
        System.out.println(unsortedPriorityQueue.min());
        System.out.println(unsortedPriorityQueue.removeMin());
        System.out.println(unsortedPriorityQueue.removeMin());
        System.out.println(unsortedPriorityQueue.removeMin());

        sortedPriorityQueue.insert(7,3);
        sortedPriorityQueue.insert(0,4);
        sortedPriorityQueue.insert(2,13);

        System.out.println(sortedPriorityQueue.removeMin());
        System.out.println(sortedPriorityQueue.min());
        System.out.println(sortedPriorityQueue.removeMin());
        System.out.println(sortedPriorityQueue.size());
        System.out.println(sortedPriorityQueue.removeMin());
        System.out.println(sortedPriorityQueue.removeMin());
    }
}
