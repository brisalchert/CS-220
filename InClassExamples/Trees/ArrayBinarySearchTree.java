//----------------------------------------------------------------------------------------------------------------------
//  ArrayBinarySearchTree.java                Author: Brian Salchert
//
//  Array-based implementation of the Binary Search Tree in Java.
//----------------------------------------------------------------------------------------------------------------------

package Trees;

import java.util.ArrayList;

public class ArrayBinarySearchTree<E extends Comparable<E>> extends ArrayBinaryTree<E> {
    /**
     * Constructor: Creates a new ArrayBinarySearchTree with a root with data e and size of 1
     * @param e the data to be stored in the root
     */
    public ArrayBinarySearchTree(E e) {
        super(e);
    }

    /**
     * Constructor: Creates a new ArrayBinarySearchTree with a size of 0
     */
    public ArrayBinarySearchTree() {
        super();
    }

    /**
     * Constructor: Creates a new ArrayBinarySearchTree with a given list of nodes
     * @param list the list of nodes
     * @throws IllegalArgumentException if the list is not a valid binary search tree
     */
    public ArrayBinarySearchTree(ArrayList<E> list) throws IllegalArgumentException {
        super(list);

        if (!validateTree(0, list)) {
            throw new IllegalArgumentException("Array is not a valid binary search tree");
        }
    }

    /**
     * Support method for validating a list of nodes as a binary search tree
     * @param r the rank to start validating from
     * @param list the list of nodes
     * @return true if the list is a valid binary search tree, false otherwise
     */
    private boolean validateTree(int r, ArrayList<E> list) {
        int leftChild = (2 * r) + 1;
        int rightChild = (2 * r) + 2;

        // Check for left child node (Short-circuit "&&" stops exception being thrown)
        if ((leftChild < list.size()) && (getElement(leftChild) != null)) {
            // Validate the left child node's subtree
            if (!validateTree(leftChild, list)) {
                return false;
            }

            // Compare the left child to its parent
            if (getElement(leftChild).compareTo(getElement(r)) >= 0) {
                return false;
            }
        }

        // Check for right child node (Short-circuit "&&" stops exception being thrown)
        if ((rightChild < list.size()) && (getElement(rightChild) != null)) {
            // Validate the right child node's subtree
            if (!validateTree(rightChild, list)) {
                return false;
            }

            // Compare the right child to its parent
            if (getElement(rightChild).compareTo(getElement(r)) <= 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Adds a new element in the proper place in the binary search tree
     * @param e the element to be added
     * @return the rank of the added element
     */
    public int addElement(E e) {
        if (isEmpty()) {
            return createRoot(e);
        }

        return attachNode(root(), e);
    }

    /**
     * Support method for attaching a node in its proper location in the binary search tree
     * @param r the rank to attach the node at
     * @param e the data to store in the node
     * @return the rank of the new node
     * @throws IllegalArgumentException if the node's element already exists in the tree
     */
    private int attachNode(int r, E e) throws IllegalArgumentException {
        if (e.compareTo(getElement(r)) == 0) {
            throw new IllegalArgumentException("Element already exists in tree");
        }

        if (e.compareTo(getElement(r)) < 0) {
            if (getElement(left(r)) != null) {
                return attachNode(left(r), e);
            }

            return add(left(r), e);
        }

        if (getElement(right(r)) != null) {
            return attachNode(right(r), e);
        }

        return add(right(r), e);
    }

    /**
     * Searches the binary search tree for the specified element and returns true if it is found
     * @param e the element to search for
     * @return true if the element exists in the tree
     */
    public boolean search(E e) {
        int r = root();

        try {
            while (getElement(r) != null) {
                if (getElement(r).compareTo(e) == 0) {
                    return true;
                }

                if (getElement(r).compareTo(e) > 0) {
                    r = left(r);
                }
                else {
                    r = right(r);
                }
            }
        }
        catch (IllegalArgumentException error) {
            return false;
        }

        return false;
    }

    /**
     * Override method for disabling the addLeftChild method
     * @param pRank the rank of the parent node
     * @param e the data to be stored in the child node
     * @return never reached
     * @throws IllegalAccessError for illegal use of addLeftChild
     */
    @Override
    public int addLeftChild(int pRank, E e) throws IllegalAccessError {
        throw new IllegalAccessError("Direct insertion of nodes is illegal for a binary search tree");
    }

    /**
     * Override method for disabling the addRightChild method
     * @param pRank the rank of the parent node
     * @param e the data to be stored in the child node
     * @return never reached
     * @throws IllegalAccessError for illegal use of addRightChild
     */
    @Override
    public int addRightChild(int pRank, E e) throws IllegalAccessError {
        throw new IllegalAccessError("Direct insertion of nodes is illegal for a binary search tree");
    }
}
