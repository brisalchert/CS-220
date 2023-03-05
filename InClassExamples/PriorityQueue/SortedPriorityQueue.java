//----------------------------------------------------------------------------------------------------------------------
//  SortedPriorityQueue.java              Author: Brian Salchert
//
//  Sorted Priority Queue in Java from the AbstractPriorityQueue ADT. Requires 0(n) runtime to add an element, but
//  0(1) runtime to retrieve an element since it is sorted.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

import TreeTest.Position;

import java.util.Comparator;

public class SortedPriorityQueue<K extends Comparable<K>,V> extends AbstractPriorityQueue<K,V> {
    /**
     * Constructor: Creates a new SortedPriorityQueue from its superclass
     */
    public SortedPriorityQueue() {
        super();
    }

    /**
     * Constructor: Creates a new SortedPriorityQueue from its superclass with a specified comparator
     * @param comp the comparator for keys
     */
    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Inserts a new key-value pair into the priority queue sorted by key
     * @param key the key of the new entry
     * @param value the value of the new entry
     * @return the new entry
     * @throws IllegalArgumentException if the new entry is invalid
     */
    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        Entry<K,V> entry = new PQEntry<>(key, value);

        Position<Entry<K,V>> position = list.last();

        while ((position != null) && (comp.compare(entry.getKey(), position.getElement().getKey()) < 0)) {
            position = list.before(position);
        }

        if (position == null) {
            list.addFirst(entry);
        }
        else {
            list.addAfter(position, entry);
        }

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

        return list.first().getElement();
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

        return list.remove(list.first());
    }
}
