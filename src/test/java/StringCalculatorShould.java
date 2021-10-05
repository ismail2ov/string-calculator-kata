import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void return_0_for_empty_string() {
        int actual = calculator.add("");

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void return_same_number_if_string_contains_single_number() {
        int actual = calculator.add("1");

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void return_sum_of_two_numbers_separated_by_commas() {
        int actual = calculator.add("1,2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void return_sum_of_six_comma_separated_numbers() {
        int actual = calculator.add("6, 4, 8, 45, 51, 0");

        assertThat(actual).isEqualTo(114);
    }
}
