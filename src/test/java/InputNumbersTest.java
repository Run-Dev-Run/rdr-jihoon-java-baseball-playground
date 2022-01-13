import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputNumbersTest {

    private InputNumbers inputNumbers;

    @BeforeEach
    void setUp() {
        inputNumbers = new InputNumbers();
    }

    @Test
    void test_addInputNumber_success() {
        int validNumber = 1;

        inputNumbers.addInputNumber(validNumber);

        assertThat(inputNumbers.getInputNumbers().size()).isEqualTo(1);
        // TODO: 매우 찜찜하다.. 테스트를 위해서 이렇게 까지 타고 들어가는게 맞을까??
        assertThat(inputNumbers.getInputNumbers().get(0).getNumber()).isEqualTo(validNumber);
    }

    @Test
    void test_addInputNumber_duplicated_number() {
        int validNumber = 1;
        int duplicatedNumber = validNumber;

        inputNumbers.addInputNumber(validNumber);

        assertThatThrownBy(() -> inputNumbers.addInputNumber(duplicatedNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
