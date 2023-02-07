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

        // Add 1000 to the end of the list
        myLinkedList.addAtTail(1000);

        // Add 600 at index 1 in the list
        myLinkedList.addAtIndex(1, 600);

        // Attempt to add 5 at index 7 in the list
        myLinkedList.addAtIndex(7, 5);

        // Add 40 at index 0 in the list
        myLinkedList.addAtIndex(0, 40);

        // Remove the item at index 3 in the list
        myLinkedList.deleteAtIndex(3);

        // Attempt to remove the item at index 8 in the list
        myLinkedList.deleteAtIndex(8);

        // Attempt to get the first 5 values in the list
        for (int index = 0; index < 5; index++) {
            System.out.println(myLinkedList.get(index));
        }
    }
}
