public class TaxCalculator {

    private static final double BASIC_SALES_TAX = 0.10;
    private static final double IMPORT_DUTY = 0.05;

    public static double calculateTax(Item item) {
        double tax = 0.0;
        if (!item.isExempt()) {
            tax += item.getPrice() * BASIC_SALES_TAX;
        }
        if (item.isImported()) {
            tax += item.getPrice() * IMPORT_DUTY;
        }
        return roundTax(tax);
    }

    private static double roundTax(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
