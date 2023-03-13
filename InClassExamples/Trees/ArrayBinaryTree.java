//----------------------------------------------------------------------------------------------------------------------
//  ArrayBinaryTree.java                Author: Brian Salchert
//
//  Array-based implementation of the Binary Tree in Java.
//----------------------------------------------------------------------------------------------------------------------

package Trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayBinaryTree<E> {
    private ArrayList<E> binaryTree;
    private E root;
    private int size;

    /**
     * Constructor: Creates a new ArrayBinaryTree with a root node and a size of 1
     * @param e the data to be stored in the root
     */
    public ArrayBinaryTree(E e) {
        binaryTree = new ArrayList<>();

        root = e;

        binaryTree.add(0, root);
        size = 1;
    }

    /**
     * Constructor: Creates a new ArrayBinaryTree with a given list of nodes
     * @param list the list of nodes
     */
    public ArrayBinaryTree(ArrayList<E> list) {
        binaryTree = list;

        root = list.get(0);

        size = list.size();
    }

    /**
     * Constructor: Creates a new ArrayBinaryTree with a size of 0
     */
    public ArrayBinaryTree() {
        binaryTree = new ArrayList<>();
        size = 0;
    }

    /**
     * Creates a new root node for an empty tree
     * @param e the data to be stored in the root node
     * @return the root node's rank
     * @throws IllegalStateException if the root already exists
     */
    public int createRoot(E e) throws IllegalStateException {
       if (root != null) {
           throw new IllegalStateException("Root already exists");
       }

        root = e;
        size++;

       return binaryTree.indexOf(root);
    }

    /**
     * Returns the index (or rank) of a node in the binary tree
     * @param node the node to get the index of
     * @return the index of the node
     */
    public int getRank(E node) {
        return binaryTree.indexOf(node);
    }

    /**
     * Checks if an element already exists in the tree
     * @param e the element to check existence of
     * @return true if the element exists
     */
    private boolean existsInTree(E e) {
        return (binaryTree.indexOf(e) > 0);
    }

    /**
     * Sets the value of a node at a particular rank in the tree
     * @param rank the rank to set the value for
     * @param e the new node value
     * @throws IllegalArgumentException if the value already exists in the tree
     */
    private void setElement(int rank, E e) throws IllegalArgumentException {
        try {
            if (binaryTree.get(rank) != null) {
                throw new IllegalArgumentException("Cannot set rank: index is occupied");
            }
        }
        catch (IndexOutOfBoundsException error) {
            if (existsInTree(e)) {
                throw new IllegalArgumentException("Cannot add element " + e + ": element already exists in tree");
            }

            binaryTree.add(rank, e);

            return;
        }

        if (existsInTree(e)) {
            throw new IllegalArgumentException("Cannot add element " + e + ": element already exists in tree");
        }

        binaryTree.add(rank, e);
    }

    /**
     * Method for adding to the ArrayList with inherited classes
     * @param rank the rank to add new node at
     * @param e the data to be stored in the new node
     * @return the rank of the item added
     */
    protected int add(int rank, E e) {
        binaryTree.add(rank, e);

        return getRank(e);
    }

    /**
     * Gets the element stored at a particular rank
     * @param rank the rank of the element to fetch
     * @return the element
     * @throws IllegalArgumentException if no node exists at the rank
     */
    protected E getElement(int rank) throws IllegalArgumentException {
        E node;

        try {
            node = binaryTree.get(rank);
        }
        catch (IndexOutOfBoundsException error) {
            throw new IllegalArgumentException("No node at rank " + rank);
        }

        return node;
    }

    /**
     * Support method for verifying a node is not null
     * @param r the rank of the node
     * @return the element stored in the node
     * @throws IllegalArgumentException if the node is null
     */
    protected E verifyNode(int r) throws IllegalArgumentException {
        if (getElement(r) != null) {
            return getElement(r);
        }
        else {
            throw new IllegalArgumentException("Node is null");
        }
    }

    /**
     * Adds a left child node to the parent node at rank pRank
     * @param pRank the rank of the parent node
     * @param e the data to be stored in the child node
     * @return the rank of the new child node
     * @throws IllegalArgumentException if the parent node's rank does not have an element
     */
    public int addLeftChild(int pRank, E e) throws IllegalArgumentException {
        E parent = verifyNode(pRank);

        setElement(((2 * getRank(parent)) + 1), e);
        size++;

        return binaryTree.indexOf(e);
    }

    /**
     * Adds a right child node to the parent node at rank pRank
     * @param pRank the rank of the parent node
     * @param e the data to be stored in the child node
     * @return the rank of the new child node
     * @throws IllegalArgumentException if the parent node's rank does not have an element
     */
    public int addRightChild(int pRank, E e) throws IllegalArgumentException {
        E parent = verifyNode(pRank);

        setElement(((2 * getRank(parent)) + 2), e);
        size++;

        return binaryTree.indexOf(e);
    }

    /**
     * Removes the node at a particular rank and returns its data
     * @param rank the rank of the node to be removed
     * @return the data stored in the node
     * @throws IllegalArgumentException if the node is internal
     */
    public E remove(int rank) throws IllegalArgumentException {
        if (isInternal(rank)) {
            throw new IllegalArgumentException("Cannot remove internal node");
        }

        E temp = binaryTree.get(rank);
        setElement(rank, null);
        size--;

        return temp;
    }

    /**
     * Sets the data in the node at a particular rank to e
     * @param rank the rank of the node
     * @param e the new data to be stored in the node
     */
    public void set(int rank, E e) {
        setElement(rank, e);
    }

    /**
     * Gets the rank of the left child of the node at rank pRank
     * @param pRank the rank of the parent node
     * @return the rank of the left child node
     * @throws IllegalArgumentException if there is no left child or parent
     */
    public int left(int pRank) throws IllegalArgumentException {
        E parent = verifyNode(pRank);
        E left;

        try {
            left = binaryTree.get((2 * getRank(parent)) + 1);
        }
        catch (IndexOutOfBoundsException error) {
            throw new IllegalArgumentException("Node at rank " + pRank + " has no left child");
        }

        return binaryTree.indexOf(left);
    }

    /**
     * Gets the rank of the right child of the node at rank pRank
     * @param pRank the rank of the parent node
     * @return the rank of the right child node
     * @throws IllegalArgumentException if there is no right child or parent
     */
    public int right(int pRank) throws IllegalArgumentException {
        E parent = verifyNode(pRank);
        E right;

        try {
            right = binaryTree.get((2 * getRank(parent)) + 2);
        }
        catch (IndexOutOfBoundsException error) {
            throw new IllegalArgumentException("Node at rank " + pRank + " has no right child");
        }

        return binaryTree.indexOf(right);
    }

    /**
     * Gets the rank of the sibling of the node at rank r
     * @param r the rank of the first child node
     * @return the rank of the other child node
     * @throws IllegalArgumentException if the sibling is null
     */
    public int sibling(int r) throws IllegalArgumentException {
        E sibling = verifyNode(r);
        E otherChild;

        // Determine if node is a left or right child
        if ((getRank(sibling) % 2) == 1) {
            otherChild = binaryTree.get(getRank(sibling) + 1);
        }
        else {
            otherChild = binaryTree.get(getRank(sibling) - 1);
        }

        return binaryTree.indexOf(otherChild);
    }

    /**
     * Gets the size of the binary tree
     * @return the size of the binary tree
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty
     * @return true if the tree is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns an iterator on the elements of the binary tree using preorder traversal
     * @return an iterator on the elements of the binary tree
     */
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();

        return binaryTree.iterator();
    }

    /**
     * Traverses the binary tree using preorder traversal from a particular start rank, storing elements in a list
     * @param r the start rank
     * @param list the list to store elements in
     */
    public List<E> preorder(int r, List<E> list) {
        list.add(binaryTree.get(r));

        if (binaryTree.get(left(r)) != null) {
            preorder(left(r), list);
        }

        if (binaryTree.get(right(r)) != null) {
            preorder(right(r), list);
        }

        return list;
    }

    /**
     * Gets the rank of the root of the binary tree
     * @return the rank of the root of the tree
     */
    public int root() {
        return binaryTree.indexOf(root);
    }

    /**
     * Gets the rank of the parent of a node in the binary tree
     * @param r the rank of the child node
     * @return the rank of the parent node
     * @throws IllegalArgumentException if the child is null
     */
    public int parent(int r) {
        E child = verifyNode(r);
        E parent;

        parent = binaryTree.get((getRank(child) - 1) / 2);

        return binaryTree.indexOf(parent);
    }

    /**
     * Returns the number of children of the node at rank r
     * @param r the rank of the parent node
     * @return the number of children of the parent node
     */
    public int numChildren(int r) {
        E node = verifyNode(r);
        int counter = 0;

        if (binaryTree.get(left(getRank(node))) != null) {
            counter++;
        }

        if (binaryTree.get(right(getRank(node))) != null) {
            counter++;
        }

        return counter;
    }

    /**
     * Checks if the node at rank r is internal
     * @param r the rank of the node
     * @return true if the node has at least one child
     */
    public boolean isInternal(int r) {
        E node = verifyNode(r);

        return ((binaryTree.get(left(getRank(node))) != null) || (binaryTree.get(right(getRank(node))) != null));
    }

    /**
     * Checks if the node at rank r is external
     * @param r the rank of the node
     * @return true if the node has no children
     */
    public boolean isExternal(int r) {
        return ((binaryTree.get(left(r)) == null) && (binaryTree.get(right(r)) == null));
    }

    /**
     * Checks if the node at rank r is the root
     * @param r the rank of the node
     * @return true if the node is the root
     */
    public boolean isRoot(int r) throws IllegalArgumentException {
        return (binaryTree.get(r) == root);
    }
}
