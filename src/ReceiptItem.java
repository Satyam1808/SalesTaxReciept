public class ReceiptItem {
    private final Item item;
    private final double tax;
    private final double totalPrice;

    public ReceiptItem(Item item, double tax) {
        this.item = item;
        this.tax = tax;
        this.totalPrice = item.getPrice() + tax;
    }

    public String getDescription() {
        return (item.isImported() ? "imported " : "") + item.getName();
    }

    public double getTax() {
        return tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Item getItem() {
        return item;
    }
}
