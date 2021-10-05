import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> negativesList = new ArrayList<>();
        String[] arr = input.split(delimiter);

        int sum = Arrays.stream(arr)
                .mapToInt(number -> Integer.parseInt(number.trim()))
                .peek(n -> {
                    if (n < 0) {
                        negativesList.add(String.valueOf(n));
                    }
                })
                .sum();

        if (negativesList.size() > 0) {
            throw new NumberFormatException("negatives not allowed: " + String.join(",", negativesList));
        }

        return sum;
    }

    private int add(String inputWithDelimiter, int newLineIndex) {
        String delimiter = inputWithDelimiter.substring(DELIMITER_PREFIX.length(), newLineIndex);
        String input = inputWithDelimiter.substring(newLineIndex + 1);
        return add(input, delimiter);
    }
}
