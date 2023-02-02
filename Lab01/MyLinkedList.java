public class MyLinkedList {
    private int val;
    private int index;
    private MyLinkedList next;
    private MyLinkedList prev;
    private MyLinkedList head;
    private MyLinkedList tail;
    private MyLinkedList current;

    // Constructor: sets up a MyLinkedList node with val
    public MyLinkedList(int val) {
        this.val = val;
        next = null;
        prev = null;
        head = this;
        tail = this;
    }

    // Returns the value of val at the node with the specified index in the linked list
    // Returns -1 if the index is invalid
    public int get(int index) {
        current = head;
        this.index = 0;

        // Traverse the list to the correct index
        while (this.index < index) {
            current = current.next;
            this.index++;

            if (current == null) {
                return -1;
            }
        }

        // Return the value of val
        return current.val;
    }

    // Adds a node with value val at the head of the linked list
    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val);

        // Set the new node's pointer to the current head node
        newNode.next = head;

        // Set the new node as the new head node
        head = newNode;

        // Set the old head node's prev node
        newNode.next.prev = newNode;
    }

    // Appends a node with value val at the tail of the linked list
    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val);

        // Set the new node's prev node
        newNode.prev = tail;

        // Set the prev tail's next node
        tail.next = newNode;

        // Set the new node to be the new tail
        tail = newNode;
    }

    // Adds a node with value val at the specified index of the linked list
    // Appends to the end of the list if the index is equal to the length of the list
    // Does not insert the node if index is greater than the length of the list
    public void addAtIndex(int index, int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        current = head;
        this.index = 0;

        // Traverse the list to the node before the specified index
        while (this.index < (index - 1)) {
            current = current.next;
            this.index++;

            if (current == null) {
                System.out.println("Could not insert node at index " + index + ": index too large");
                return;
            }
        }

        // Set the new node's next pointer
        newNode.next = current.next;

        // Set the new node's prev pointer
        newNode.prev = current;

        // Set the current node's next pointer
        current.next = newNode;

        // Set the next node's prev pointer
        newNode.next.prev = newNode;
    }

    // Deletes the node at the specified index in the list
    public void deleteAtIndex(int index) {

    }
}