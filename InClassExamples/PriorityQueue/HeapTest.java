//----------------------------------------------------------------------------------------------------------------------
//  HeapTest.java               Author: Brian Salchert
//
//  Driver class for testing the Heap Priority Queue implementation in Java.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

public class HeapTest {
    public static void main(String[] args) {
        HeapPriorityQueue<Integer, Integer> heapPriorityQueue = new HeapPriorityQueue<Integer, Integer>();
        SortedPriorityQueue<Integer, Integer> sortedPriorityQueue = new SortedPriorityQueue<Integer, Integer>();

        System.out.println("\nSelection-Sort-Priority-Queue runtime: " + getPQRuntime(sortedPriorityQueue));
        System.out.println();
        System.out.println("\nHeap-Priority-Queue runtime: " + getPQRuntime(heapPriorityQueue));
    }

    public static long getPQRuntime(AbstractPriorityQueue<Integer, Integer> queue) {
        long startTime, endTime;

        startTime = System.nanoTime();

        queue.insert(1, 6);
        queue.insert(7, 9);
        queue.insert(2, 3);
        queue.insert(3, 8);
        queue.insert(5, 1);
        queue.insert(4, 3);
        queue.insert(6, 2);

        for (int i = 0; i < 7; i++) {
            System.out.println(queue.removeMin());
        }

        endTime = System.nanoTime();

        return endTime - startTime;
    }
}
