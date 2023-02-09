package QueueTest;

public class QueueTest {
    public static void main (String[] args) {
        ArrayQueue<Integer> waitingLine = new ArrayQueue<Integer>(20);

        System.out.println(waitingLine.enqueue(50));
        System.out.println(waitingLine.enqueue(900));
        System.out.println(waitingLine.dequeue());
        System.out.println(waitingLine.dequeue());
        System.out.println(waitingLine.dequeue());
        System.out.println(waitingLine.enqueue(150));
        System.out.println(waitingLine.first());
        System.out.println(waitingLine.size());
    }
}
