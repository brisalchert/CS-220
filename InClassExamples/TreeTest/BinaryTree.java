//----------------------------------------------------------------------------------------------------------------------
//  BinaryTree.java               Author: Brian Salchert
//
//  Binary tree ADT extending the Tree ADT.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

public interface BinaryTree<E> extends Tree<E> {
    Position<E> left(Position<E> p);
    Position<E> right(Position<E> p);
    Position<E> sibling (Position<E> p);
}
