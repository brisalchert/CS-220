//----------------------------------------------------------------------------------------------------------------------
//  MyStack.java              Author: Brian Salchert
//
//  Problem: Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should
//  support all the functions of a normal stack (push, top, pop, and empty).
//
//  Implement the MyStack class:
//    • void push(int x) Pushes element x to the top of the stack.
//    • int pop() Removes the element on the top of the stack and returns it.
//    • int top() Returns the element on the top of the stack.
//    • boolean empty() Returns true if the stack is empty, false otherwise.
//----------------------------------------------------------------------------------------------------------------------

package Question9;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> stackQueue = new LinkedList<>();
    private Queue<Integer> auxQueue = new LinkedList<>();

    /**
     * Pushes element x onto the stack using the both queues
     * @param x element to be pushed
     */
    public void push(int x) {
        // Push the new element onto the auxiliary queue
        auxQueue.add(x);

        // Dequeue each element from the stack queue and Enqueue them to the auxiliary queue
        while (!stackQueue.isEmpty()) {
            auxQueue.add(stackQueue.remove());
        }

        // Dequeue each element from the auxiliary queue and Enqueue them to the stack queue
        while (!auxQueue.isEmpty()) {
            stackQueue.add(auxQueue.remove());
        }
    }

    /**
     * Pops the top element off the stack and returns it
     * @return the top element of the stack
     */
    public int pop() {
        // Remove and return the top element of the stack queue
        return stackQueue.remove();
    }

    /**
     * Returns the top element of the stack without removing it.
     * @return the top element of the stack
     * @throws NullPointerException if the stack is empty.
     */
    public int top() throws NullPointerException {
        NullPointerException problem = new NullPointerException("Stack is empty.");

        // Peek the top element of the stack queue without removing it. If the stack is empty, throw an exception
        if (stackQueue.isEmpty()) {
            throw problem;
        }

        return stackQueue.peek();
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack has no elements, false otherwise
     */
    public boolean empty() {
        return stackQueue.isEmpty();
    }
}
