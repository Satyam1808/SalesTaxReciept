import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readInputsFromConsole() {
        List<String> inputs = new ArrayList<>();
        System.out.println("Enter your items (type 'done' when finished):");

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("done")) break;
            inputs.add(line);
        }

        return inputs;
    }
}
