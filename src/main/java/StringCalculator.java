import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (!input.contains(",")) {
            return Integer.parseInt(input);
        }

        String[] arr = input.split("[\n,]");

        return Arrays.stream(arr).mapToInt(number -> Integer.parseInt(number.trim())).sum();
    }
}
