import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator(0.10, 0.05);
        PurchaseParser parser = new PurchaseParser(taxCalculator);
        ReceiptPrinter printer = new ReceiptPrinter();
        InputHandler inputHandler = new InputHandler();

        boolean moreReceipts = true;

        while (moreReceipts) {
            List<String> inputs = inputHandler.readInputsFromConsole();
            Receipt receipt = new Receipt();

            for (String line : inputs) {
                try {
                    ReceiptItem receiptItem = parser.parseLine(line);
                    receipt.addItem(receiptItem);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            printer.printReceipt(receipt);

            System.out.println("Add another receipt? (yes/no)");
            String response = new Scanner(System.in).nextLine();
            moreReceipts = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you. Exiting.");
    }
}