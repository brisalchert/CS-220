//----------------------------------------------------------------------------------------------------------------------
//  ArrayBinaryTree.java                Author: Brian Salchert
//
//  Array-based implementation of the Binary Tree in Java.
//----------------------------------------------------------------------------------------------------------------------

package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayBinaryTree<E> implements BinaryTree<E> {
    protected static class Node<E> implements Position<E> {
        E data;

        /**
         * Constructor: Creates a new node with data e
         * @param e data to be stored in the node
         */
        public Node(E e) {
            data = e;
        }

        /**
         * Gets the data stored in a node
         * @return the data stored in the node
         * @throws IllegalStateException if the data is null
         */
        @Override
        public E getElement() throws IllegalStateException {
            if (data == null) {
                throw new IllegalStateException("Node data is null");
            }

            return data;
        }

        /**
         * Sets the data in the node to e
         * @param e the new data to be stored in the node
         */
        public void setElement(E e) {
            data = e;
        }
    }

    /**
     * Creates a new node with stored data e by accessing the Node constructor
     * @param e data to be stored in the node
     * @return the new node
     */
    private Node<E> createNode(E e) {
        return new Node<E>(e);
    }

    private ArrayList<Node<E>> binaryTree;
    private Node<E> root;
    private int size;

    /**
     * Creates a new ArrayBinaryTree with a root and a size of 1
     * @param e the data to be stored in the root
     */
    public ArrayBinaryTree(E e) {
        binaryTree = new ArrayList<>();

        root = createNode(e);

        binaryTree.add(0, root);
        size = 1;
    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node<E> node)) {
            throw new IllegalArgumentException("Invalid position type");
        }

        // Condition for invalidating a node
        if (node.data == null) {
            throw new IllegalArgumentException("Position is no longer valid");
        }

        return node;
    }

    /**
     * Returns the index (or rank) of a node in the binary tree
     * @param node the node to get the index of
     * @return the index of the node
     */
    private int getRank(Node<E> node) {
        return binaryTree.indexOf(node);
    }

    /**
     * Sets the rank of a node in the tree
     * @param rank the rank to set the index of the node to
     * @param node the node to set the rank for
     */
    private void setRank(int rank, Node<E> node) throws IllegalArgumentException {
        try {
            if (binaryTree.get(rank) != null) {
                throw new IllegalArgumentException("Cannot set rank: index is occupied");
            }
        }
        catch (IndexOutOfBoundsException error) {
            binaryTree.add(rank, node);

            return;
        }

        binaryTree.add(rank, node);
    }

    /**
     * Adds a left child node to the parent node at position p
     * @param p the position of the parent node
     * @param e the data to be stored in the child node
     * @return the position of the new child node
     * @throws IllegalArgumentException if the parent node cannot be validated
     */
    public Position<E> addLeftChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        Node<E> leftChild = createNode(e);
        setRank(((2 * getRank(parent)) + 1), leftChild);
        size++;

        return leftChild;
    }

    /**
     * Adds a right child node to the parent node at position p
     * @param p the position of the parent node
     * @param e the data to be stored in the child node
     * @return the position of the new child node
     * @throws IllegalArgumentException if the parent node cannot be validated
     */
    public Position<E> addRightChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        Node<E> rightChild = createNode(e);
        setRank(((2 * getRank(parent)) + 2), rightChild);
        size++;

        return rightChild;
    }

    /**
     * Removes the node at position p and returns its data
     * @param p the position of the node to be removed
     * @return the data stored in the node
     * @throws IllegalArgumentException if the node at position p is internal
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        if (isInternal(p)) {
            throw new IllegalArgumentException("Cannot remove internal node");
        }

        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(null);
        size--;

        return temp;
    }

    /**
     * Sets the data in the node at position p to e
     * @param p the position of the node
     * @param e the new data to be stored in the node
     * @throws IllegalArgumentException if the position of the node cannot be validated
     */
    public void set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);

        node.setElement(e);
    }

    /**
     * Gets the left child of the node at position p
     * @param p the position of the parent node
     * @return the position of the left child node
     * @throws IllegalArgumentException if the position of the node cannot be validated
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        try {
            return binaryTree.get((2 * getRank(parent)) + 1);
        }
        catch (IndexOutOfBoundsException error) {
            return null;
        }
    }

    /**
     * Gets the right child of the node at position p
     * @param p the position of the parent node
     * @return the position of the right child node
     * @throws IllegalArgumentException if the position of the node cannot be validated
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        try {
            return binaryTree.get((2 * getRank(parent)) + 2);
        }
        catch (IndexOutOfBoundsException error) {
            return null;
        }
    }

    /**
     * Gets the sibling of the node at position p
     * @param p the position of the first child node
     * @return the position of the sibling node
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Node<E> node = validate(p);

        // Determine if node is a left or right child
        if ((getRank(node) % 2) == 1) {
            return binaryTree.get(getRank(node) + 1);
        }
        else {
            return binaryTree.get(getRank(node) - 1);
        }
    }

    /**
     * Gets the size of the binary tree
     * @return the size of the binary tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty
     * @return true if the tree is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns an iterator on the elements of the binary tree using preorder traversal
     * @return an iterator on the elements of the binary tree
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            final Iterator<Position<E>> iter = positions().iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public E next() {
                return iter.next().getElement();
            }
        };
    }

    /**
     * Returns an iterable list of the positions in the binary tree using preorder traversal
     * @return an iterable collection of the positions in the binary tree
     * @throws IllegalArgumentException if a position cannot be validated
     */
    @Override
    public Iterable<Position<E>> positions() throws IllegalArgumentException {
        List<Position<E>> list = new ArrayList<>();
        preorder(root, list);

        return list;
    }

    /**
     * Traverses the binary tree using preorder traversal from a particular start position, storing positions in a list
     * @param p the start position
     * @param list the list to store positions in
     * @throws IllegalArgumentException if a node cannot be validated
     */
    public void preorder(Position<E> p, List<Position<E>> list) throws IllegalArgumentException {
        list.add(p);

        if (left(p) != null) {
            preorder(left(p), list);
        }

        if (right(p) != null) {
            preorder(right(p), list);
        }
    }

    /**
     * Gets the position of the root of the binary tree
     * @return the position of the root of the tree
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Gets the position of the parent of a node in the binary tree
     * @param p the position of the child node
     * @return the position of the parent node
     * @throws IllegalArgumentException if the position of the child node cannot be validated
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> child = validate(p);

        return binaryTree.get((getRank(child) - 1) / 2);
    }

    /**
     * Returns an iterable list of the positions of the children of the node at position p
     * @param p the position of the parent node
     * @return an iterable list of the positions of the children of the node at position p
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> children = new ArrayList<>();

        if (left(p) != null) {
            children.add(left(p));
        }

        if (right(p) != null) {
            children.add(right(p));
        }

        return children;
    }

    /**
     * Returns the number of children of the node at position p
     * @param p the position of the parent node
     * @return the number of children of the parent node
     */
    @Override
    public int numChildren(Position<E> p) {
        int counter = 0;

        if (left(p) != null) {
            counter++;
        }

        if (right(p) != null) {
            counter++;
        }

        return counter;
    }

    /**
     * Checks if the node at position p is internal
     * @param p the position of the node
     * @return true if the node has at least one child
     */
    @Override
    public boolean isInternal(Position<E> p) {
        if ((left(p) != null) || right(p) != null) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the node at position p is external
     * @param p the position of the node
     * @return true if the node has no children
     */
    @Override
    public boolean isExternal(Position<E> p) {
        return ((left(p) == null) && (right(p) == null));
    }

    /**
     * Checks if the node at position p is the root
     * @param p the position of the node
     * @return true if the node is the root
     * @throws IllegalArgumentException if the position cannot be validated
     */
    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        return (node == root);
    }
}
