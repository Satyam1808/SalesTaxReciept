import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();

    public void addItem(ReceiptItem item) {
        items.add(item);
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public double getTotalTaxes() {
        return items.stream().mapToDouble(ReceiptItem::getTax).sum();
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(ReceiptItem::getTotalPrice).sum();
    }
}