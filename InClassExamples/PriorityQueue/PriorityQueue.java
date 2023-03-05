//----------------------------------------------------------------------------------------------------------------------
//  PriorityQueue.java              Author: Brian Salchert
//
//  Priority Queue ADT in java.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

public interface PriorityQueue<K extends Comparable<K>,V> {
    // Inserts a new key-value pair into the priority queue.
    Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
    // Finds and returns the smallest key in the queue without removing it.
    Entry<K,V> min();
    // Finds and returns the smallest key in the queue and removes it.
    Entry<K,V> removeMin();
}
