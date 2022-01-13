import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputNumbersListTest {

    private InputNumbers inputNumbers;

    @BeforeEach
    void setUp() {
        inputNumbers = new InputNumbersList();
    }

    @Test
    void test_addInputNumber_success() {
        String validInputNumberStr = "1";
        inputNumbers.addInputNumber(validInputNumberStr);

        assertThat(inputNumbers.getLength()).isEqualTo(1);
    }

    @Test
    void test_addInputNumber_invalid_input_number_str() {
        String invalidInputNumberStr = "+";

        assertThatThrownBy(() -> inputNumbers.addInputNumber(invalidInputNumberStr))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
