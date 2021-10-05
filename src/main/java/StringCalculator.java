import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = "[\n,]";

        int newLineIndex = input.indexOf("\n");
        if ((newLineIndex > 1) && (input.startsWith("//"))) {
            delimiter = input.substring(2, newLineIndex);
            input = input.substring(newLineIndex + 1);
        }
        String[] arr = input.split(delimiter);

        return Arrays.stream(arr).mapToInt(number -> Integer.parseInt(number.trim())).sum();
    }
}
