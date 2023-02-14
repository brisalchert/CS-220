//----------------------------------------------------------------------------------------------------------------------
//  ArrayStack.java             Author: Brian Salchert
//
//  Stack implementation using an array.
//----------------------------------------------------------------------------------------------------------------------
package StackTest;

public class ArrayStack<E> {
    private E[] stack;
    private int top;
    private int size;

    public ArrayStack(int size) {
        stack = (E[]) new Object[size];
        top = 0;
        size = 0;
    }

    public void push(E e){
        if (!isEmpty()) {
            top++;
        }

        stack[top] = e;
        size++;
    }

    public E pop(E e) {
        E temp = stack[top];
        stack[top] = null;
        size--;

        if (!isEmpty()) {
            top--;
        }

        return temp;
    }

    public E top() {
        return stack[top];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
