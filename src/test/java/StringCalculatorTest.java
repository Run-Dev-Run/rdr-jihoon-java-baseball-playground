import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("runCalculator()는 올바른 문자열이 주어졌을 때, 계산된 값을 반환한다.")
    void test_runCalculator_success() {
        String validStr = "1+2*4/2";

        Integer actual = stringCalculator.runCalculator(validStr);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"++2+3", "-2+3/5"})
    @DisplayName("runCalculator()는 올바르지 않은 문자열이 주어졌을 때, IllegalArgumentException를 던집니다.")
    void test_runCalculator_IllegalArgumentException(String invalidStr) {
        Assertions.assertThatThrownBy(() -> stringCalculator.runCalculator(invalidStr))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:1:2:3", "-:3:1:2", "*:1:2:2", "/:6:2:3"}, delimiter = ':')
    @DisplayName("calculate()는 operator(연산자), leftValue, rightValue에 대해 계산된 값을 반환합니다.")
    void test_calculate_success(String operator, Integer leftValue, Integer rightValue, Integer expected) {
        Integer actual = stringCalculator.calculate(operator, leftValue, rightValue);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("calculate()는 올바르지 않은 operator(연산자)를 인자로 받을 경우 IllegalArgumentException를 던집니다.")
    void test_calculate_IllegalArgumentException를() {
        String invalidOperator = "$";
        Integer leftValue = 1;
        Integer rightValue = 2;

        Assertions.assertThatThrownBy(() -> stringCalculator.calculate(invalidOperator, leftValue, rightValue))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
