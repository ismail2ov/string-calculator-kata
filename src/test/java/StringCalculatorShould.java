import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void return_sum_of_numbers_separated_by_commas_or_new_lines() {
        int actual = calculator.add("1\n2,3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void return_sum_of_two_numbers_separated_by_new_line() {
        int actual = calculator.add("1\n2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void return_sum_of_numbers_with_custom_delimiter() {
        int actual = calculator.add("//;\n1;2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void throw_an_exception_when_detect_negative_numbers() {
        assertThatThrownBy(() -> calculator.add("//;\n1;2;-9;105;-1"))
                .isExactlyInstanceOf(NumberFormatException.class)
                .hasMessageContaining("negatives not allowed: -9,-1");
    }

    @Test
    void return_sum_of_numbers_ignoring_bigger_than_1000() {
        int actual = calculator.add("2\n1001");

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void return_sum_of_numbers_with_delimiters_of_any_length() {
        int actual = calculator.add("//[***]\n1***2***3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void return_sum_of_numbers_with_multiples_delimiters() {
        int actual = calculator.add("//[*][%]\n1*2%3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void return_sum_of_numbers_with_multiples_delimiters_of_any_length() {
        int actual = calculator.add("//[*][%%]\n1*2%%3");

        assertThat(actual).isEqualTo(6);
    }
}
