//----------------------------------------------------------------------------------------------------------------------
//  PriorityQueueTest.java              Author: Brian Salchert
//
//  Driver class for Priority Queue classes and related sorting algorithms.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

import java.util.Comparator;

import Trees.LinkedPositionalList;

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
        LinkedPositionalList<Integer[]> unsortedList = new LinkedPositionalList<Integer[]>();
        Integer[][] entryList = {{1, 5}, {7, 2}, {8, 1}, {3, 3}, {-2, 6}};
        long startTime;
        long endTime;
        long runTime;

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

        for (Integer[] entry : entryList) {
            unsortedList.addLast(entry);
        }

        startTime = System.nanoTime();
        selectionSortPQ(unsortedList);
        endTime = System.nanoTime();

        runTime = endTime - startTime;

        System.out.println("Selection Sort runtime: " + runTime);

        startTime = System.nanoTime();
        insertionSortPQ(unsortedList);
        endTime = System.nanoTime();

        runTime = endTime - startTime;

        System.out.println("Insertion Sort runtime: " + runTime);
    }

    public static LinkedPositionalList<Entry<Integer,Integer>> selectionSortPQ(LinkedPositionalList<Integer[]> list) {
        UnsortedPriorityQueue<Integer,Integer> sortPQ = new UnsortedPriorityQueue<Integer,Integer>();

        return doSort(list, sortPQ);
    }

    public static LinkedPositionalList<Entry<Integer,Integer>> insertionSortPQ(LinkedPositionalList<Integer[]> list) {
        SortedPriorityQueue<Integer,Integer> sortPQ = new SortedPriorityQueue<Integer,Integer>();

        return doSort(list, sortPQ);
    }

    private static LinkedPositionalList<Entry<Integer,Integer>> doSort(LinkedPositionalList<Integer[]> list,
                                                                       AbstractPriorityQueue<Integer,Integer> pq) {
        while (!list.isEmpty()) {
            pq.insert(list.first().getElement()[0], list.first().getElement()[1]);
            list.remove(list.first());
        }

        LinkedPositionalList<Entry<Integer,Integer>> finalList = new LinkedPositionalList<Entry<Integer,Integer>>();

        while (!pq.isEmpty()) {
            finalList.addLast(pq.removeMin());
        }

        return finalList;
    }
}
