//----------------------------------------------------------------------------------------------------------------------
//  MyCircularQueue.java                Author: Brian Salchert
//
//  Implementation of the Circular ArrayQueue and its methods.
//----------------------------------------------------------------------------------------------------------------------

public class MyCircularQueue {
    // We use the Integer class so that values in the queue can be set to null when deleted.
    private Integer[] queue;
    private int front;
    private int rear;
    private int size;

    /**
     * Initializes the queue with size k
     * @param k the size of the queue
     */
    public MyCircularQueue(int k) {
        queue = new Integer [k];
        size = 0;
        front = 0;
        rear = 0;
    }

    /**
     * Gets the front item from the queue
     * @return the front item from the queue, or -1 if the queue is empty
     */
    public int front() {
        // Check if the queue is empty
        if (isEmpty()) {
            return -1;
        }

        // Return the front item in the queue
        return queue[front];
    }

    /**
     * Gets the rear item from the queue
     * @return the rear item from the queue, or -1 if the queue is empty
     */
    public int rear() {
        // Check if the queue is empty
        if (isEmpty()) {
            return -1;
        }

        // Return the rear item in the queue
        return queue[rear];
    }

    /**
     * Attempts to add the value to the end of the queue
     * @param value int to be added to the queue
     * @return true if element is successfully added, false if the queue is full
     */
    public boolean enQueue(int value) {
        // Check if the queue is full
        if (isFull()) {
            return false;
        }

        // Check if the current rear value is at the end of the array and set the new rear location
        if (rear == (queue.length - 1)) {
            rear = 0;
        }
        else {
            rear++;
        }

        // Add the new value at the rear of the queue
        queue[rear] = value;
        size++;

        return true;
    }

    /**
     * Attempts to delete the item at the start of the queue
     * @return true if the element is successfully deleted, false if the queue is empty
     */
    public boolean deQueue() {
        // Check if the queue is empty
        if (isEmpty()) {
            return false;
        }

        // Remove the element at the front of the queue
        queue[front] = null;
        size--;

        // Check if the old front value is at the end of the array and set the new front location
        if (front == (queue.length - 1)) {
            front = 0;
        }
        else {
            front ++;
        }

        return true;
    }

    /**
     * Checks if the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return size == queue.length;
    }
}
