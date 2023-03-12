//----------------------------------------------------------------------------------------------------------------------
//  Question9.java              Author: Brian Salchert
//
//  Problem: Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should
//  support all the functions of a normal stack (push, top, pop, and empty).
//
//  This is the driver class for the MyStack class.
//----------------------------------------------------------------------------------------------------------------------

package Question9;

public class HW1Question9 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(5);
        System.out.println(myStack.top());
        myStack.push(10);
        myStack.push(11);
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
