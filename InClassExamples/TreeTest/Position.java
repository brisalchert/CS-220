//----------------------------------------------------------------------------------------------------------------------
//  Position.java               Author: Brian Salchert
//
//  Position ADT for use in positional lists.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

public interface Position<E> {
    /**
     * Returns the element stored at the position
     * @return the stored element
     * @throws IllegalStateException if the given position is invalid
     */
    E getElement() throws IllegalStateException;
}
