//----------------------------------------------------------------------------------------------------------------------
//  HeapPriorityQueue.java              Author: Brian Salchert
//
//  Heap Priority Queue implementation using an array in Java.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K extends Comparable<K>,V> extends AbstractPriorityQueue<K,V> {
    protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
    protected Comparator<K> comp;

    /**
     * Constructor: Creates a new heap using the default comparator
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Constructor: Creates a new heap using a given comparator
     * @param comp the comparator to use
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Gets the index of the parent of an entry
     * @param index the index of the entry
     * @return the index of the entry's parent
     */
    protected int parent(int index) {
        return ((index - 1) / 2);
    }

    /**
     * Gets the index of the left child of an entry
     * @param index the index of the entry
     * @return the index of the entry's left child
     */
    protected int left(int index) {
        return ((index * 2) + 1);
    }

    /**
     * Gets the index of the right child of an entry
     * @param index the index of the entry
     * @return the index of the entry's right child
     */
    protected int right(int index) {
        return ((index * 2) + 2);
    }

    /**
     * Checks if an entry has a left child
     * @param index the index of the entry
     * @return true if the entry has a left child
     */
    protected boolean hasLeft(int index) {
        return (left(index) < heap.size());
    }

    /**
     * Checks if an entry has a right child
     * @param index the index of the entry
     * @return true if the entry has a right child
     */
    protected boolean hasRight(int index) {
        return (right(index) < heap.size());
    }

    /**
     * Swaps the entries at two indices in the heap
     * @param index1 the index of the first entry
     * @param index2 the index of the second entry
     */
    protected void swap(int index1, int index2) {
        Entry<K,V> temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Moves the entry at the given index upwards in the heap until heap order is restored
     * @param index the index of the entry
     */
    protected void upHeap(int index) {
        while (index > 0) {
            int parent = parent(index);

            if ((heap.get(index).getKey().compareTo(heap.get(parent).getKey())) > 0) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    /**
     * Moves the entry at the given index lower in the heap until heap order is restored
     * @param index the index of the entry
     */
    protected void downHeap(int index) {
        while (hasLeft(index)) {
            int leftIndex = left(index);
            int smallestChildIndex = leftIndex;

            if (hasRight(index)) {
                int rightIndex = right(index);

                if (heap.get(leftIndex).getKey().compareTo(heap.get(rightIndex).getKey()) > 0) {
                    smallestChildIndex = rightIndex;
                }
            }

            if (heap.get(smallestChildIndex).getKey().compareTo(heap.get(index).getKey()) >= 0) {
                break;
            }

            swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

    /**
     * Inserts a new entry into the heap and upHeaps it to the correct location
     * @param key the key of the new entry
     * @param value the value of the new entry
     * @return the new entry
     * @throws IllegalArgumentException if the entry has an invalid key
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        PQEntry<K,V> entry = new PQEntry<K, V>(key, value);

        heap.add(entry);
        upHeap(heap.size() - 1);

        return entry;
    }

    /**
     * Gets the minimum element from the heap without removing it
     * @return the minimum element of the heap
     */
    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    /**
     * Removes and returns the entry with the minimum key from the heap
     * @return the entry with the minimum key
     */
    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }

        Entry<K,V> min = heap.get(0);
        swap(0, (heap.size() - 1));

        heap.remove(heap.size() - 1);
        downHeap(0);

        return min;
    }

    /**
     * Gets the size of the heap
     * @return the size of the heap
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Checks if the heap is empty
     * @return true if the heap is empty
     */
    @Override
    public boolean isEmpty() {
        return (heap.size() == 0);
    }
}
