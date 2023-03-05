//----------------------------------------------------------------------------------------------------------------------
//  LinkedPositionalList.java              Author: Brian Salchert
//
//  Positional List implementation in Java using a Linked List.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedPositionalList<E> implements PositionalList<E> {
    protected static class Node<E> implements Position<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        /**
         * Constructor: Creates and inserts a new node into the list using its prev node
         * @param e data to be stored in the node
         * @param prev the reference to the previous node
         */
        public Node(E e, Node<E> prev, Node<E> next) {
            data = e;
            // Set prev node reference
            this.prev = prev;

            // Set the next node reference
            this.next = next;

            // Set the next node's prev reference
            if (next != null) {
                next.prev = this;
            }
        }

        /**
         * Gets the data within the node
         * @return this node's data
         * @throws IllegalStateException if the node has null data
         */
        @Override
        public E getElement() throws IllegalStateException {
            if (data == null) {
                throw new IllegalStateException("Node has no data");
            }

            return data;
        }

        /**
         * Gets the previous node
         * @return the previous node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Gets the next node
         * @return the next node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets this node's previous node to the node in the argument
         * @param prev the new previous node
         */
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        /**
         * Sets this node's next node to the node in the argument
         * @param next the new next node
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Sets the data stored in this node to the element in the argument
         * @param e the new data to be stored
         */
        public void setElement(E e) {
            data = e;
        }
    }

    /**
     * Creates a new node with data e and previous node prev
     * @param e data to be stored in the new node
     * @param prev reference to the previous node
     * @return the new node
     */
    protected Node<E> createNode(E e, Node<E> prev, Node<E> next) {
        Node<E> node = new Node<E>(e, prev, next);

        if (node.prev != null) {
            node.prev.next = node;
        }

        if (node.next != null) {
            node.next.prev = node;
        }

        return node;
    }

    protected Node<E> head = null;
    protected Node<E> tail = null;
    private int size = 0;

    /**
     * Constructor: creates a new LinkedPositionalList with size 0
     */
    public LinkedPositionalList() {
    }

    /**
     * Validates a position in the list and returns the node at that position if it is valid
     * @param p position of the node to be validated
     * @return the node at position p
     * @throws IllegalArgumentException if the position is invalid
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node<E> node)) {
            throw new IllegalArgumentException("Not a valid type of position");
        }

        // Condition for invalid node
        if (node.prev == node) {
            throw new IllegalArgumentException("Position is no longer valid");
        }

        return node;
    }

    /**
     * Gets the position of the first node in the list
     * @return the position of the head node
     */
    @Override
    public Position<E> first() {
        return head;
    }

    /**
     * Gets the position of the last node in the list
     * @return the position of the tail node
     */
    @Override
    public Position<E> last() {
        return tail;
    }

    /**
     * Checks if the list is empty
     * @return true if the size of the list is 0
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Gets the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds a root node when the list is empty
     * @param e data to be stored in the root node
     * @return the position of the root node
     */
    private Position<E> addRoot(E e) {
        head = createNode(e, null, null);
        tail = head;

        size++;

        return head;
    }

    /**
     * Adds a new node at the first position in the list
     * @param e the data to be stored in the new node
     * @return the position of the new node
     */
    @Override
    public Position<E> addFirst(E e) {
        // If the list is empty, make a new node and assign head and tail to it
        if (isEmpty()) {
            return addRoot(e);
        }

        Node<E> first = validate(head);

        // Create the new node
        Node<E> node = createNode(e, null, first);

        // Set the new node as the head node
        head = node;

        size++;

        return node;
    }

    /**
     * Creates a new node at the end of the list
     * @param e the data to be stored in the new node
     * @return the position of the new node
     */
    @Override
    public Position<E> addLast(E e) {
        if (isEmpty()) {
            return addRoot(e);
        }

        // Create the new node after the tail node
        Node<E> node = createNode(e, tail, null);

        // Assign the tail pointer to the new node
        tail = node;

        size++;

        return node;
    }

    /**
     * Sets the data of the node at position p to e, returning the old data
     * @param p the position of the node
     * @param e the new data to be stored in the node
     * @return the old data stored in the node
     */
    @Override
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);

        E temp = node.getElement();

        node.setElement(e);

        return temp;
    }

    /**
     * Removes the node at position p from the list, invalidating its position and returning its data
     * @param p the position of the node
     * @return the data in the node
     */
    @Override
    public E remove(Position<E> p) {
        Node<E> node = validate(p);

        // Check if the head or tail pointer must be moved/removed
        if (node == head) {
            if (node.next == null) {
                head = null;
            }
            else {
                head = node.next;
            }
        }

        if (node == tail) {
            if (node.prev == null) {
                tail = null;
            }
            else {
                tail = node.prev;
            }
        }

        // Set the previous node's next pointer to skip the current node
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        // Set the next node's prev pointer to skip the current node
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Invalidate the position
        node.prev = node;
        node.next = node;

        size--;

        return node.getElement();
    }

    /**
     * Creates a new node after position p
     * @param p position of the previous node
     * @param e data to be stored in the new node
     * @return the position of the new node
     */
    @Override
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> before = validate(p);

        return createNode(e, before, before.next);
    }

    /**
     * Adds a new node before position p
     * @param p position of the next node
     * @param e data to be stored in the new node
     * @return the position of the new node
     */
    @Override
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> after = validate(p);

        if (after.prev != null) {
            return createNode(e, after.prev, after);
        }
        else {
            return addFirst(e);
        }
    }

    /**
     * Gets the position of the node after p
     * @param p position of the current node
     * @return position of the node after p
     */
    @Override
    public Position<E> after(Position<E> p) {
        Node<E> before = validate(p);

        return before.next;
    }

    /**
     * Gets the position of the node before p
     * @param p position of the current node
     * @return position of the node before p
     */
    @Override
    public Position<E> before(Position<E> p) {
        Node<E> after = validate(p);

        return after.prev;
    }

    /**
     * Creates an iterator of the elements in the positional list
     * @return an iterator of the elements in the positional list
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
     * Creates an iterable list of the positions in the list
     * @return an iterable list of the positions in the list
     */
    @Override
    public Iterable<Position<E>> positions() {
        List<Position<E>> positions = new ArrayList<>();

        Node<E> current = head;
        while (current != null) {
            positions.add(current);
            current = current.next;
        }

        return positions;
    }
}
