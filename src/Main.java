import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean moreReceipts = true;

        while (moreReceipts) {
            List<String> inputs = InputHandler.readInputsFromConsole();

            Receipt receipt = new Receipt();
            for (String line : inputs) {
                try {
                    Item item = PurchaseParser.parseItem(line);
                    receipt.addItem(new ReceiptItem(item));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            ReceiptPrinter.printReceipt(receipt);

            System.out.println("Add another receipt? (yes/no)");
            moreReceipts = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you. Exiting.");
        scanner.close();
    }
}