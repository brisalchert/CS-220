//----------------------------------------------------------------------------------------------------------------------
//  InstagramUsers.java               Author: Brian Salchert
//
//  Driver class for creating a set of Instagram users and performing various operations on that set.
//----------------------------------------------------------------------------------------------------------------------
package InstagramUsers;

import java.util.ArrayList;
import java.util.LinkedList;

public class InstagramUsers {
    public static void main (String[] args) {
        ArrayList<User> instagramArray = new ArrayList<User>();
        LinkedList<User> instagramLinkedList = new LinkedList<User>();
        long startTime;
        long endTime;
        long runtime;

        // Perform Operations on the ArrayList
        startTime = System.nanoTime();

        // Insert 1,000,000 users
        for (int count = 0; count < 1000000; count++) {
            // Create new User with name John
            User john = new User("John");

            // Add John to the Arraylist
            instagramArray.add(john);
        }

        endTime = System.nanoTime();

        // Measure time for operation
        runtime = endTime - startTime;

        // Print the runtime
        System.out.println("Runtime for Inserting 1,000,000 users with an ArrayList: " + runtime + " nanoseconds");

        startTime = System.nanoTime();

        // Delete the 59,421st user
        instagramArray.remove(59420);

        endTime = System.nanoTime();

        // Measure time for operation
        runtime = endTime - startTime;

        // Print the runtime
        System.out.println("Runtime for deleting the 59,421st user with an ArrayList: " + runtime + " nanoseconds");

        startTime = System.nanoTime();

        // Insert 2 users at the beginning
        User jeff = new User("Jeff");
        User bob = new User("Bob");
        instagramArray.add(0, jeff);
        instagramArray.add(0, bob);

        endTime = System.nanoTime();

        // Measure time for operation
        runtime = endTime - startTime;

        // Print the runtime
        System.out.println("Runtime for inserting 2 users at the beginning with an ArrayList: " + runtime + " nanoseconds");

        System.out.println();

        // Perform operations on the LinkedList
        startTime = System.nanoTime();

        // Insert 1,000,000 users
        for (int count = 0; count < 1000000; count++) {
            // Create new User with name John
            User emma = new User("Emma");

            // Add John to the Arraylist
            instagramLinkedList.add(emma);
        }

        endTime = System.nanoTime();

        // Measure time for operation
        runtime = endTime - startTime;

        // Print the runtime
        System.out.println("Runtime for Inserting 1,000,000 users with a LinkedList: " + runtime + " nanoseconds");

        startTime = System.nanoTime();

        // Delete the 59,421st user
        instagramLinkedList.remove(59420);

        endTime = System.nanoTime();

        // Measure time for operation
        runtime = endTime - startTime;

        // Print the runtime
        System.out.println("Runtime for deleting the 59,421st user with a LinkedList: " + runtime + " nanoseconds");

        startTime = System.nanoTime();

        // Insert 2 users at the beginning
        User sophie = new User("Sophie");
        User bella = new User("Bella");
        instagramLinkedList.add(0, sophie);
        instagramLinkedList.add(0, bella);

        endTime = System.nanoTime();

        // Measure time for operation
        runtime = endTime - startTime;

        // Print the runtime
        System.out.println("Runtime for inserting 2 users at the beginning with a LinkedList: " + runtime + " nanoseconds");
    }
}