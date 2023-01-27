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

        firstShirt.next = secondShirt;
        secondShirt.next = thirdShirt;
        thirdShirt.next = fourthShirt;
        fourthShirt.next = fifthShirt;
        TShirtAsNode head = firstShirt;

        TShirtAsNode current = head;
        int counter = 0;

        while (current != null) {
            System.out.println("Price of T-shirt #" + counter + ": "
                + currency.format(current.getPrice()));

            counter++;

            current = current.next;
        }
    }
}
