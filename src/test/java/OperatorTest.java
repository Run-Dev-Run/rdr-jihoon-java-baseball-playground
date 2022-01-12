import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    private final String PLUS_STR = "+";
    private final String MINUS_STR = "-";
    private final String MULTIPLE_STR = "*";
    private final String DIVISION_STR = "/";
    private final String INVALID_OPERATOR_STR = "$";

    private int preNumber;
    private int postNumber;

    @BeforeEach
    void setUp() {
        preNumber = 5;
        postNumber = 2;
    }

    @Test
    void test_findOperator_success() {
        Operator foundOperator = Operator.findOperator(PLUS_STR);

        assertThat(foundOperator).isEqualTo(Operator.PLUS);
    }

    @Test
    void test_findOperator_invalid_operator() {
        assertThatThrownBy(() -> Operator.findOperator(INVALID_OPERATOR_STR))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_operate_plus() {
        int result = Operator.PLUS.operate(preNumber, postNumber);

        assertThat(result).isEqualTo(preNumber + postNumber);
    }

    @Test
    void test_operate_minus() {
        int result = Operator.MINUS.operate(preNumber, postNumber);

        assertThat(result).isEqualTo(preNumber - postNumber);
    }

    @Test
    void test_operate_multiplication() {
        int result = Operator.MULTIPLE.operate(preNumber, postNumber);

        assertThat(result).isEqualTo(preNumber * postNumber);
    }

    @Test
    void test_operate_division() {
        int result = Operator.DIVISION.operate(preNumber, postNumber);

        assertThat(result).isEqualTo(preNumber / postNumber);
    }

    @Test
    void test_operate_division_denominator_is_zero() {
        assertThatThrownBy(() -> Operator.DIVISION.operate(preNumber, 0))
            .isInstanceOf(ArithmeticException.class);
    }

}
