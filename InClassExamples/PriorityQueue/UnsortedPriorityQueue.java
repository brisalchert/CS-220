//----------------------------------------------------------------------------------------------------------------------
//  UnsortedPriorityQueue.java              Author: Brian Salchert
//
//  Unsorted Priority Queue in Java from the AbstractPriorityQueue ADT. Requires 0(1) runtime to add an element, but
//  0(n) runtime to retrieve an element since it is unsorted.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

import Trees.LinkedPositionalList;
import Trees.Position;
import Trees.PositionalList;

import java.util.Comparator;

public class UnsortedPriorityQueue<K extends Comparable<K>,V> extends AbstractPriorityQueue<K,V> {
    PositionalList<Entry<K,V>> list = new LinkedPositionalList<Entry<K,V>>();

    /**
     * Constructor: Creates a new UnsortedPriorityQueue from its superclass
     */
    public UnsortedPriorityQueue() {
        super();
    }

    /**
     * Constructor: Creates a new UnsortedPriorityQueue from its superclass with a specified comparator
     * @param comp the comparator for keys
     */
    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Finds the position of the smallest key in the list
     * @return the position of the smallest key in the list
     */
    private Position<Entry<K,V>> findMin() {
        Position<Entry<K,V>> minimum = list.first();

        if (list.size() == 1) {
            return minimum;
        }

        for (Position<Entry<K,V>> position : list.positions()) {
            if ((comp.compare(position.getElement().getKey(), minimum.getElement().getKey())) < 0) {
                minimum = position;
            }
        }

        return minimum;
    }

    /**
     * Inserts a new key-value pair into the priority queue
     * @param key key of the new entry
     * @param value value of the new entry
     * @return the new entry
     * @throws IllegalArgumentException if the new entry is invalid
     */
    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        Entry<K,V> entry = new PQEntry<>(key, value);

        list.addLast(entry);

        return entry;
    }

    /**
     * Returns but does not remove the entry with the smallest key
     * @return the entry with the smallest key
     */
    @Override
    public Entry<K,V> min() {
        if (list.isEmpty()) {
            return null;
        }

        return findMin().getElement();
    }

    /**
     * Returns and removes the entry with the smallest key
     * @return the entry with the smallest key
     */
    @Override
    public Entry<K,V> removeMin() {
        if (list.isEmpty()) {
            return null;
        }

        return list.remove(findMin());
    }

    /**
     * Gets the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks if the queue is empty
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
