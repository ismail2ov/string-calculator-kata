import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] arr = input.split("[\n,]");

        return Arrays.stream(arr).mapToInt(number -> Integer.parseInt(number.trim())).sum();
    }
}
