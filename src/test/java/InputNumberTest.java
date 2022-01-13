import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputNumberTest {

    private final String VALID_INPUT = "2";
    private final String INVALID_INPUT = "~";

    @Test
    void test_constructor_success() {
        InputNumber inputNumber = new InputNumber(VALID_INPUT);

        assertThat(inputNumber.getNumber()).isNotNull();
        assertThat(inputNumber.getNumber()).isEqualTo(Integer.parseInt(VALID_INPUT));
    }

    @Test
    void test_constructor_invalid_input() {
        assertThatThrownBy(() -> new InputNumber(INVALID_INPUT))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
