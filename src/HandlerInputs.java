import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerInputs {

    private static final Scanner scanner = new Scanner(System.in);

    public static Reciept readReceiptFromConsole() {
        Reciept receipt = new Reciept();
        System.out.println("Enter your items (type 'done' when finished):");

        while (true) {
            String input = scanner.nextLine();
            if (input.trim().equalsIgnoreCase("done")) {
                break;
            }

            try {
                Items item = parseItem(input);
                receipt.addItem(new ItemReciept(item));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input format. Try again.");
            }
        }

        return receipt;
    }

    private static Items parseItem(String input) {
        Pattern pattern = Pattern.compile("(\\d+) (.*) at (\\d+\\.\\d{2})");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format");
        }

        String name = matcher.group(2);
        double price = Double.parseDouble(matcher.group(3));

        boolean isImported = name.toLowerCase().contains("imported");
        boolean isExempt = isExemptProduct(name);

        name = name.replace("imported ", "");

        return new Items(name, price, isImported, isExempt);
    }

    private static boolean isExemptProduct(String name) {
        String lowerName = name.toLowerCase();
        return lowerName.contains("book") ||
                lowerName.contains("chocolate") ||
                lowerName.contains("pill");
    }

}
