import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputNumberTest {

    @Test
    void test_constructor_success() {
        int validNumber = 1;
        InputNumber inputNumber = new InputNumber(validNumber);

        assertThat(inputNumber).isNotNull();
    }

    @Test
    void test_constructor_range_over() {
        int rangeOverNumber = 10;

        assertThatThrownBy(() -> new InputNumber(rangeOverNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
