//----------------------------------------------------------------------------------------------------------------------
//  PositionalList.java               Author: Brian Salchert
//
//  Positional List ADT with methods for use in the Tree interface.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

import java.util.Iterator;

public interface PositionalList<E> extends Iterable<E> {
    // Returns the position of the first element, or null if empty.
    Position<E> first();
    // Returns the position of the last element, or null if empty.
    Position<E> last();
    // Returns the position in the list directly before position p, or null if p is the first position.
    Position<E> before(Position<E> p);
    // Returns the position in the list directly after position p, or null if p is the last position.
    Position<E> after(Position<E> p);
    // Returns true if the list is empty.
    boolean isEmpty();
    // Returns the number of elements in the list.
    int size();
    // Inserts a new element e at the front of the list, returning the position of the new element.
    Position<E> addFirst(E e);
    // Inserts a new element e at the back of the list, returning the position of the new element.
    Position<E> addLast(E e);
    // Inserts a new element e in the list, just before position p, returning the position of the new element.
    Position<E> addBefore(Position<E> p, E e);
    // Inserts a new element e in the list, just after position p, returning the position of the new element.
    Position<E> addAfter(Position<E> p, E e);
    // Replaces the element at position p with element e, returning the element formerly at position p.
    E set(Position<E> p, E e);
    // Removes and returns the element at position p in the list, invalidating the position.
    E remove(Position<E> p);
    // Returns an iterator of the elements in the positional list
    Iterator<E> iterator();
    // Returns an iterable list of positions in the list
    Iterable<Position<E>> positions();
}
