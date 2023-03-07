//----------------------------------------------------------------------------------------------------------------------
//  LinkedBinaryTree.java               Author: Brian Salchert
//
//  Binary Tree implementation using a linked structure with nodes implementing the Position ADT.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    /**
     * Support class for the nodes of the binary tree
     * @param <E> The data type to be stored in the nodes
     */
    protected static class Node<E> implements Position<E> {
        private E data;
        private Node<E> parent;
        private Node<E> leftChild;
        private Node<E> rightChild;

        /**
         * Constructor: Generates a new node given its data, parent, and left and right children
         * @param e data to be stored in the new node
         * @param parent parent node
         * @param leftChild left child node
         * @param rightChild right child node
         */
        public Node(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            data = e;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
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
         * Gets the parent of this node
         * @return the parent of this node
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * Gets the leftChild of this node
         * @return the leftChild of this node
         */
        public Node<E> getLeftChild() {
            return leftChild;
        }

        /**
         * Gets the rightChild of this node
         * @return the rightChild of this node
         */
        public Node<E> getRightChild() {
            return rightChild;
        }

        /**
         * Sets the parent for this node
         * @param parent the new parent node
         */
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        /**
         * Sets the leftChild for this node
         * @param leftChild the new leftChild node
         */
        public void setLeftChild(Node<E> leftChild) {
            this.leftChild = leftChild;
        }

        /**
         * Sets the rightChild for this node
         * @param rightChild the new rightChild node
         */
        public void setRightChild(Node<E> rightChild) {
            this.rightChild = rightChild;
        }

        /**
         * Sets the data in this node to a new value
         * @param e the new data to be stored in the node
         */
        public void setElement(E e) {
            data = e;
        }
    }

    /**
     * Creates a new node with stored data, a parent node, and left and right children nodes
     * @param e the data to be stored in the node
     * @param parent the parent node
     * @param leftChild the left child node
     * @param rightChild the right child node
     * @return the new node
     */
    private Node<E> createNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
        return new Node<E>(e, parent, leftChild, rightChild);
    }

    private Node<E> root;
    private int size;

    /**
     * Constructor: Creates a new LinkedBinaryTree with a root node and size of 1
     * @param e
     */
    protected LinkedBinaryTree(E e) {
        root = createNode(e, null, null, null);
        size = 1;
    }

    /**
     * Validates the position of a node and then returns the node itself
     * @param p the position of the node to validate
     * @return the node that was validated
     * @throws IllegalArgumentException if the position is not an instance of Node or if the position is invalid
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node<E> node)) {
            throw new IllegalArgumentException("Invalid position type");
        }

        // Condition for invalidating a node
        if ((node.getParent() == null) && (node != root)) {
            throw new IllegalArgumentException("Position is no longer in the tree");
        }

        return node;
    }

    /**
     * Adds a left child node to the node at position p
     * @param p the position of the parent node
     * @param e the data to be stored in the child node
     * @return the position of the left child node
     * @throws IllegalArgumentException if the parent node already has a left child
     */
    public Position<E> addLeftChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getLeftChild() != null) {
            throw new IllegalArgumentException("Node already has a left child");
        }

        Node<E> leftChild = createNode(e, parent, null, null);

        parent.setLeftChild(leftChild);
        size++;

        return leftChild;
    }

    /**
     * Adds a right child node to the node at position p
     * @param p the position of the parent node
     * @param e the data to be stored in the child node
     * @return the position of the right child node
     * @throws IllegalArgumentException if the parent node already has a right child
     */
    public Position<E> addRightChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getRightChild() != null) {
            throw new IllegalArgumentException("Node already has a right child");
        }

        Node<E> rightChild = createNode(e, parent, null, null);

        parent.setRightChild(rightChild);
        size++;

        return rightChild;
    }

    /**
     * Removes the node at position p and returns its data
     * @param p the position of the node to be removed
     * @return the data stored in the removed node
     * @throws IllegalArgumentException if the node is not external
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        if (isInternal(p)) {
            throw new IllegalArgumentException("Invalid removal: node is not external");
        }

        Node<E> node = validate(p);
        node.setParent(null);
        size--;

        return node.getElement();
    }

    /**
     * Sets the data in the node at position p to e
     * @param p the position of the node
     * @param e the new data to be stored in the node
     */
    public void set(Position<E> p, E e) {
        Node<E> node = validate(p);

        node.setElement(e);
    }

    /**
     * Gets the left child node of the node at position p
     * @param p the position of the parent node
     * @return the position of the left child node
     * @throws IllegalArgumentException if the node does not have a left child
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getLeftChild() == null) {
            throw new IllegalArgumentException("Node does not have a left child");
        }

        return parent.getLeftChild();
    }

    /**
     * Gets the right child node of the node at position p
     * @param p the position of the parent node
     * @return the position of the right child node
     * @throws IllegalArgumentException if the node does not have a right child
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getRightChild() == null) {
            throw new IllegalArgumentException("Node does not have a right child");
        }

        return parent.getRightChild();
    }

    /**
     * Gets the sibling of the node at position p
     * @param p the position of the other child node
     * @return the position of the sibling node
     * @throws IllegalArgumentException if the child node has no sibling
     */
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (node.parent.getLeftChild() == node) {
            return node.parent.getRightChild();
        }
        else {
            if (node.parent.getRightChild() == node) {
                return node.parent.getLeftChild();
            }
        }

        throw new IllegalArgumentException("Node has no sibling");
    }

    /**
     * Returns the position of the parent node of a given node
     * @param p the position of the child node
     * @return the position of the parent node
     * @throws IllegalArgumentException if the node at position p cannot be validated
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        return node.getParent();
    }

    /**
     * Gets the size of the tree
     * @return the size of the tree
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
     * Creates an iterator on the elements in the tree using preorder traversal
     * @return an iterator on the tree's elements
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
     * Returns an iterable collection of the positions in the tree using preorder traversal
     * @return an iterable collection of the positions in the tree
     * @throws IllegalArgumentException if a node cannot be validated in the preorder traversal
     */
    @Override
    public Iterable<Position<E>> positions() throws IllegalArgumentException {
        List<Position<E>> list = new ArrayList<>();
        Position<E> p = root;

        preorder(p, list);

        return list;
    }

    /**
     * Traverses the tree using preorder traversal from a particular start position, storing the positions in a list
     * @param p the starting position for the preorder traversal
     * @param list the list to store the positions in
     * @throws IllegalArgumentException if a node cannot be validated
     */
    public void preorder(Position<E> p, List<Position<E>> list) throws IllegalArgumentException {
        list.add(p);

        Node<E> node = validate(p);

        if (node.getLeftChild() != null) {
            preorder(node.getLeftChild(), list);
        }

        if (node.getRightChild() != null) {
            preorder(node.getRightChild(), list);
        }
    }

    /**
     * Returns the root node's position
     * @return the position of the root node
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Checks if a given node is the root node of the tree
     * @param p the position of the node to be checked
     * @return true if the node is the root, false otherwise
     * @throws IllegalArgumentException if the node at position p cannot be validated
     */
    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        return (node == root);
    }

    /**
     * Checks if a given node is an external node
     * @param p the position of the node to be checked
     * @return true if the node is external, false otherwise
     * @throws IllegalArgumentException if the node at position p cannot be validated
     */
    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        return ((node.getLeftChild() == null) && (node.getRightChild() == null));
    }

    /**
     * Checks if a given node is an internal node
     * @param p the position of the node to be checked
     * @return true if the node is internal, false otherwise
     * @throws IllegalArgumentException if the node at position p cannot be validated
     */
    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        return ((node.getLeftChild() != null) || (node.getRightChild() != null));
    }

    /**
     * Gets the number of children that belong to a particular node
     * @param p the position of the parent node
     * @return the number of children of the parent node
     * @throws IllegalArgumentException if the node at position p cannot be validated
     */
    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        int counter = 0;

        if (node.getLeftChild() != null) {
            counter++;
        }

        if (node.getRightChild() != null) {
            counter++;
        }

        return counter;
    }

    /**
     * Returns an iterable collection of the children of a particular node
     * @param p the position of the parent node
     * @return an iterable collection of the children of the node at position p
     * @throws IllegalArgumentException if the node at position p cannot be validated
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        ArrayList<Position<E>> children = new ArrayList<>();

        if (node.getLeftChild() != null) {
            children.add(left(node));
        }

        if (node.getRightChild() != null) {
            children.add(right(node));
        }

        return children;
    }
}
