import java.util.Arrays;

public class StringCalculator {

    public static final String DELIMITER_PREFIX = "//";

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = "[\n,]";

        int newLineIndex = input.indexOf("\n");
        if ((newLineIndex > DELIMITER_PREFIX.length()) && (input.startsWith(DELIMITER_PREFIX))) {
            return add(input, newLineIndex);
        }
        return add(input, delimiter);
    }

    private int add(String input, String delimiter) {
        String[] arr = input.split(delimiter);

        return Arrays.stream(arr).mapToInt(number -> Integer.parseInt(number.trim())).sum();
    }

    private int add(String inputWithDelimiter, int newLineIndex) {
        String delimiter = inputWithDelimiter.substring(DELIMITER_PREFIX.length(), newLineIndex);
        String input = inputWithDelimiter.substring(newLineIndex + 1);
        return add(input, delimiter);
    }
}
