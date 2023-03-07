//----------------------------------------------------------------------------------------------------------------------
//  LinkedTree.java               Author: Brian Salchert
//
//  Tree implementation using a linked structure with nodes implementing the Position ADT.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class LinkedTree<E> implements Tree<E> {
    /**
     * Support class for the nodes of the Linked Tree
     * @param <E> The data type to be stored in the nodes
     */
    private static class Node<E> implements Position<E> {
        private E data;
        private Node<E> parent;
        private List<Node<E>> children;

        /**
         * Constructor: creates a node from its stored data and parent node
         * @param e the data to be stored in the new node
         * @param parent the parent node
         */
        public Node(E e, Node<E> parent, List<Node<E>> children) {
            data = e;
            this.parent = parent;
            this.children = children;
        }

        /**
         * Returns the data stored in the node
         * @return the data stored in the node
         * @throws IllegalStateException if node has no data
         */
        @Override
        public E getElement() throws IllegalStateException {
            if (data == null) {
                throw new IllegalStateException("Node data is null");
            }

            return data;
        }

        /**
         * Returns the parent node of this node
         * @return the parent node of this node
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * Returns a list of the children of this node
         * @return a list of the children of this node
         */
        public List<Node<E>> getChildren() {
            return children;
        }

        /**
         * Sets the data in this node to e
         * @param e the new data to be stored in the node
         */
        public void setElement(E e) {
            data = e;
        }

        /**
         * Sets the parent node of this node to a particular node
         * @param parentNode the new parent node
         */
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        /**
         * Sets the list of children of this node to a particular list of nodes
         * @param childrenList the list of new children nodes
         */
        public void setChildren(List<Node<E>> childrenList) {
            children = childrenList;
        }
    }

    /**
     * Creates a new node with stored data, a parent node, and a list of children nodes
     * @param e data to be stored in the node
     * @param parent parent node of the new node
     * @param children list of children nodes
     * @return the new node
     */
    protected Node<E> createNode(E e, Node<E> parent, List<Node<E>> children) {
        return new Node<E>(e, parent, children);
    }

    private Node<E> root;
    private int size;

    /**
     * Constructor: Sets up the tree with a parent node and data e
     * @param e data in the parent node
     */
    protected LinkedTree(E e) {
        root = createNode(e, null, null);
        size = 1;
    }

    /**
     * Adds a new child node to the tree at a specified position with a given value
     * @param p the position of the new node's parent
     * @param e the element to be stored in the new node
     * @return the position of the new node
     * @throws IllegalArgumentException if the parent node position cannot be validated
     */
    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        // Add the new child to the list of children for the parent
        Node<E> parent = validate(p);
        List<Node<E>> children = parent.getChildren();

        Node<E> child = createNode(e, parent, null);
        children.add(child);

        parent.setChildren(children);
        size++;

        return child;
    }

    /**
     * Adds a new sibling node to the tree at a specified position with a given value
     * @param p the position of the existing sibling node
     * @param e the element to be stored in the new node
     * @return the position of the new node
     * @throws IllegalArgumentException if the existing sibling node position cannot be validated
     */
    public Position<E> addSibling(Position<E> p, E e) throws IllegalArgumentException {
        // Add the new sibling as a child of the existing sibling's parent
        Node<E> sibling = validate(p);
        Node<E> parent = sibling.getParent();

        return addChild(parent, e);
    }

    /**
     * Gets the child node of a particular parent node at a particular index in the parent node's list of children
     * @param p the position of the parent node
     * @param index the index of the child node in the list of children
     * @return the position of the child node
     * @throws IllegalArgumentException if the position p cannot be validated
     */
    public Position<E> getChild(Position<E> p, int index) throws IllegalArgumentException {
        // Get the child of the parent node
        Node<E> parent = validate(p);

        return parent.getChildren().get(index);
    }

    /**
     * Removes a node from a given position in the tree as long as it does not have any children
     * @param p the position of the node to be removed
     * @return the element stored in the removed node
     * @throws IllegalArgumentException if the node is an internal node
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
     * Returns the size of the tree
     * @return size of the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
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
     * Validates the position of a node and then returns the node itself
     * @param p the position of the node to validate
     * @return the node that was validated
     * @throws IllegalArgumentException if the position is not an instance of Node or if the position is invalid
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node<E> node)) {
            throw new IllegalArgumentException("Invalid Position Type");
        }

        if ((node.getParent() == null) && (node != root)) {
            throw new IllegalArgumentException("Position is no longer in the tree");
        }

        return node;
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

        if (node.getChildren() != null) {
            for (Position<E> child : node.getChildren()) {
                preorder(child, list);
            }
        }
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

        return (node.getChildren() == null);
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

        return (node.getChildren() != null);
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

        return node.getChildren().size();
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

        return new ArrayList<>(node.getChildren());
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
}
