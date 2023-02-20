public class TShirtAsNode {
    public double tShirtPrice;
    public TShirtAsNode next;

    public TShirtAsNode() {
        tShirtPrice = 0;
        next = null;
    }

    public void setPrice(double price) {
        tShirtPrice = price;
    }

    public double getPrice() {
        return tShirtPrice;
    }
}
