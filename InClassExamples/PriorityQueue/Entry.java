//----------------------------------------------------------------------------------------------------------------------
//  Entry.java              Author: Md Kamruzzaman Sarker
//
//  Interface for the Entry ADT, which represents a key-value pair.
//----------------------------------------------------------------------------------------------------------------------

package PriorityQueue;

public interface Entry<K,V> {
    K getKey();
    V getValue();
}
