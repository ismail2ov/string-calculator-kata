public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (!input.contains(",")) {
            return Integer.parseInt(input);
        }

        String[] arr = input.split(",");

        return Integer.parseInt(arr[0].trim()) + Integer.parseInt(arr[1].trim());
    }
}
