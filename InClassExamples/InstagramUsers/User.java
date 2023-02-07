//----------------------------------------------------------------------------------------------------------------------
//  User.java               Author: Brian Salchert
//
//  Class for creating an Instagram User with a name and an id.
//----------------------------------------------------------------------------------------------------------------------
package InstagramUsers;

public class User {
    private String name;
    private int id;
    private static int count = 1;

    //------------------------------------------------------------------------------------------------------------------
    //  Constructor: sets up a new user with a given name and assigns them an id.
    //------------------------------------------------------------------------------------------------------------------
    public User(String name) {
        // Set User's name
        this.name = name;

        // Assign an id number to the User
        id = count;

        // Increment the count for further id assignments
        count++;
    }
}
