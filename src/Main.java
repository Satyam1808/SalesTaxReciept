import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean moreReceipts = true;

        while (moreReceipts) {
            Reciept receipt = HandlerInputs.readReceiptFromConsole();
            RecieptPrinter.printReceipt(receipt);

            System.out.println("Add another receipt? (yes/no)");
            String response = scanner.nextLine();
            moreReceipts = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you. Exiting.");
        scanner.close();
    }
}