import java.text.NumberFormat;

public class LinkedListTest {
    public static void main (String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        TShirtAsNode firstShirt = new TShirtAsNode();
        firstShirt.setPrice(0);

        TShirtAsNode secondShirt = new TShirtAsNode();
        secondShirt.setPrice(1);

        TShirtAsNode thirdShirt = new TShirtAsNode();
        thirdShirt.setPrice(2);

        TShirtAsNode fourthShirt = new TShirtAsNode();
        fourthShirt.setPrice(3);

        TShirtAsNode fifthShirt = new TShirtAsNode();
        fifthShirt.setPrice(4);

        TShirtAsNode head = firstShirt;
        firstShirt.next = secondShirt;
        secondShirt.next = thirdShirt;
        thirdShirt.next = fourthShirt;
        fourthShirt.next = fifthShirt;

        TShirtAsNode current = head;
        int counter = 0;

        while (current != null) {
            counter++;

            System.out.println("Price of T-shirt #" + counter + ": "
                + currency.format(current.getPrice()));

            current = current.next;
        }

        System.out.println();

        // Create references for reversing the list
        current = head;
        TShirtAsNode prev = null;
        TShirtAsNode temp;

        // Reverse the list
        while (current != null) {
            // Set temp to the next node
            temp = current.next;
            // Reverse the pointer of the current node
            current.next = prev;

            // Move references forward
            prev = current;
            current = temp;
        }

        // Set new head node
        head = prev;

        current = head;

        while (current != null) {
            System.out.println("Price of T-shirt #" + counter + ": "
                    + currency.format(current.getPrice()));

            counter--;

            current = current.next;
        }
    }
}
