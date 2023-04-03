//----------------------------------------------------------------------------------------------------------------------
//  TestHashing.java                Author: Brian Salchert
//
//  Class for testing the Hashmap by creating a dictionary of words
//----------------------------------------------------------------------------------------------------------------------

package TestHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashing {
    public static void main(String[] args) {
        // Create a dictionary for English to Spanish word meanings

        // Declare Hashmap
        HashMap<String, String> engToSpnDictionary = new HashMap<>();

        // Insert word & meaning
        engToSpnDictionary.put("Welcome", "Bienvenido");
        engToSpnDictionary.put("Hello", "Hola");
        engToSpnDictionary.put("Go", "Irr");    // Incorrect value to replace later

        // Perform the search
        System.out.println();
        System.out.println("The Spanish word for Welcome is " + engToSpnDictionary.get("Welcome"));
        System.out.println();

        // Delete words
        engToSpnDictionary.remove("Welcome");

        // Modify Meaning
        engToSpnDictionary.put("Go", "Ir"); // Replace the incorrect value

        // Iterate
        Set<Map.Entry<String, String>> engWords = engToSpnDictionary.entrySet();

        System.out.println("Words in the dictionary: ");
        for (Map.Entry<String, String> entry : engWords) {
            System.out.println(entry.getKey() + " translates to " + entry.getValue());
        }
    }
}
