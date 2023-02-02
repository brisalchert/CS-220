public class LinkedListDriver {
    public static void main (String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(0);

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtIndex(1, 3);
        myLinkedList.addAtIndex(0, 4);
        myLinkedList.deleteAtIndex(3);

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(4));
    }
}
