import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurchaseParser {
    private static final List<String> EXEMPT_KEYWORDS = List.of("book", "chocolate", "pill");

    public static Item parseItem(String input) {
        Pattern pattern = Pattern.compile("(\\d+) (.*) at (\\d+\\.\\d{2})");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format: " + input);
        }

        String name = matcher.group(2);
        double price = Double.parseDouble(matcher.group(3));

        boolean isImported = name.toLowerCase().contains("imported");
        boolean isExempt = isExemptProduct(name);

        name = name.replace("imported ", "");

        return new Item(name, price, isImported, isExempt);
    }

    private static boolean isExemptProduct(String name) {
        String lower = name.toLowerCase();
        return EXEMPT_KEYWORDS.stream().anyMatch(lower::contains);
    }
}