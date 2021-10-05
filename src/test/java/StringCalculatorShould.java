import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {

    @Test
    void return_0_for_empty_string() {
        StringCalculator calculator = new StringCalculator();

        int actual = calculator.add("");

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void return_same_number_if_string_contains_single_number() {
        StringCalculator calculator = new StringCalculator();

        int actual = calculator.add("1");

        assertThat(actual).isEqualTo(1);
    }
}
