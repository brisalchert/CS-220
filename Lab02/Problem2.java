//----------------------------------------------------------------------------------------------------------------------
//  Problem2.java                Author: Brian Salchert
//
//  Driver class for the Circular ArrayQueue.
//----------------------------------------------------------------------------------------------------------------------

public class Problem2 {
    public static void main (String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.front());
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.rear());
    }
}
