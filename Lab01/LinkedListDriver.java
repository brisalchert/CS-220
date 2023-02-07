//----------------------------------------------------------------------------------------------------------------------
//  LinkedListDriver.java               Author: Brian Salchert
//
//  Driver class for MyLinkedList.java
//----------------------------------------------------------------------------------------------------------------------

public class LinkedListDriver {
    public static void main (String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(0);

        // Add 1 to the start of the list
        myLinkedList.addAtHead(1);

        // Add 2 to the end of the list
        myLinkedList.addAtTail(2);

        // Add 3 at index 1 in the list
        myLinkedList.addAtIndex(1, 3);

        // Add 4 at index 0 in the list
        myLinkedList.addAtIndex(0, 4);

        // Remove the item at index 3 in the list
        myLinkedList.deleteAtIndex(3);

        // Attempt to get the first 5 values in the list
        for (int index = 0; index < 5; index++) {
            System.out.println(myLinkedList.get(index));
        }
    }
}
