import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {

    @Test
    void return_0_for_empty_string() {
        StringCalculator calculator = new StringCalculator();

        int actual = calculator.add("");

        assertThat(actual).isEqualTo(0);
    }
}
