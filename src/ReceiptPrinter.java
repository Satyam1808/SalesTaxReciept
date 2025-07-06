public class ReceiptPrinter {

    public static void printReceipt(Receipt receipt) {
        for (ReceiptItem item : receipt.getItems()) {
            System.out.printf("1 %s: %.2f%n", item.getDescription(), item.getTotalPrice());
        }
        System.out.printf("Sales Taxes: %.2f%n", receipt.getTotalTaxes());
        System.out.printf("Total: %.2f%n%n", receipt.getTotalPrice());
    }
}
