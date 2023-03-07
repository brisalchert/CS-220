//----------------------------------------------------------------------------------------------------------------------
//  BinarySearchTree.java               Author: Brian Salchert
//
//  Binary Search Tree ADT for use in a binary search tree implementation in Java.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

public interface BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    // Search the BST for a node containing the element e.
    public boolean search(E e);
}
