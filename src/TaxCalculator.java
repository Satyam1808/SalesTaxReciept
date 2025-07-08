public class TaxCalculator {
    private final double basicSalesTax;
    private final double importDuty;

    public TaxCalculator(double basicSalesTax, double importDuty) {
        this.basicSalesTax = basicSalesTax;
        this.importDuty = importDuty;
    }

    public double calculateTax(Item item) {
        double tax = 0.0;
        if (!item.isExempt()) {
            tax += item.getPrice() * basicSalesTax;
        }
        if (item.isImported()) {
            tax += item.getPrice() * importDuty;
        }
        return roundTax(tax);
    }

    private double roundTax(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}