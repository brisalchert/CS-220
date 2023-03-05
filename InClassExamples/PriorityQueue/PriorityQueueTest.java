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

        UnsortedPriorityQueue<Integer,Integer> priorityQueue = new UnsortedPriorityQueue<Integer,Integer>();

        priorityQueue.insert(3, 4);
        priorityQueue.insert(2, 5);
        priorityQueue.insert(4, 1);

        System.out.println(priorityQueue.removeMin());
        System.out.println(priorityQueue.min());
        System.out.println(priorityQueue.removeMin());
        System.out.println(priorityQueue.removeMin());
        System.out.println(priorityQueue.removeMin());
    }
}
