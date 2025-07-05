public class ItemReciept {

    private final Items item;
    private final double tax;
    private final double totalPrice;

    public ItemReciept(Items item) {
        this.item = item;
        this.tax = CalculatorForTax.calculateTax(item);
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

    public Items getItem() {
        return item;
    }

}
