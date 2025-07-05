import java.util.ArrayList;
import java.util.List;

public class Reciept {

    private final List<ItemReciept> items = new ArrayList<>();

    public void addItem(ItemReciept item) {
        items.add(item);
    }

    public List<ItemReciept> getItems() {
        return items;
    }

    public double getTotalTaxes() {
        return items.stream().mapToDouble(ItemReciept::getTax).sum();
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(ItemReciept::getTotalPrice).sum();
    }

}
