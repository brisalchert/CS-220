//----------------------------------------------------------------------------------------------------------------------
//  AbstractPriorityQueue.java              Author: Brian Salchert
//
//  Abstract Priority Queue class for use in unsorted or sorted priority queues.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K extends Comparable<K>,V> implements PriorityQueue<K,V> {
    protected static class PQEntry<K,V> implements Entry<K,V> {
        K key;
        V value;

        public PQEntry(K key, V value) {
            checkKey(key);

            this.key = key;
            this.value = value;
        }

        private void checkKey(K key) throws IllegalArgumentException {
            if (key == null) {
                throw new IllegalArgumentException("Key is invalid");
            }
        }

        /**
         * Gets the key of a PQEntry
         * @return key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Gets the value of a PQEntry
         * @return value
         */
        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
             return "Key: " + getKey() + ", Value: " + getValue();
        }
    }
    protected Comparator<K> comp;

    /**
     * Constructor: Creates a new AbstractPriorityQueue without a specified comparator
     */
    protected AbstractPriorityQueue() {
        this.comp = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                return o1.compareTo(o2);
            }
        };
    }

    /**
     * Constructor: Creates a new AbstractPriorityQueue with a specified comparator
     * @param comp the comparator for keys
     */
    protected AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }

    abstract int size();
    abstract boolean isEmpty();
}
