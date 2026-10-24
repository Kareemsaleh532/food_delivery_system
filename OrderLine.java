public class OrderLine {
    private final MenuItem item;
    private final int quantity;

    public OrderLine(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getLineTotal() {
        return item.calculatePrice() * quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
