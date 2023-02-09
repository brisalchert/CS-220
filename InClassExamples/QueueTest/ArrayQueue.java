package QueueTest;

import java.util.ArrayList;
import java.util.Queue;

public class ArrayQueue<E> {
    private E[] data;
    private int front;
    private int size;

    //------------------------------------------------------------------------------------------------------------------
    //  Constructors: Initialize a queue with a default capacity or explicit capacity
    //------------------------------------------------------------------------------------------------------------------
    public ArrayQueue() {
        data = (E[]) new Object[50];
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Returns the current number of elements in the queue
    //------------------------------------------------------------------------------------------------------------------
    public int size() {
        return size;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Returns true if the queue is empty
    //------------------------------------------------------------------------------------------------------------------
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Returns the first element in the queue without removing it from the queue
    //------------------------------------------------------------------------------------------------------------------
    public E first() {
        if (isEmpty()) {
            return null;
        }

        return data[front];
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Adds the element to the end of the queue
    //------------------------------------------------------------------------------------------------------------------
    public boolean enqueue(E e) throws IllegalStateException {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full.");
        }

        int avail = (front + size) % data.length;
        data[avail] = e;
        size++;
        return true;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Removes and returns the first element in the queue
    //------------------------------------------------------------------------------------------------------------------
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E out = data[front];
        data[front] = null;
        size--;

        front = (front + 1) % data.length;

        return out;
    }
}
