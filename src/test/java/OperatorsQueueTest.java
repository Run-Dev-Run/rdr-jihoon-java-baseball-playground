import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorsQueueTest {

    private Operators operators;

    @BeforeEach
    void setUp() {
        operators = new OperatorsQueue();
    }

    // TODO : Queue를 Operators러 한번 감쌌는데 이게 맞나...?
    // TODO : 일단 new로 생성하고 이후에 set 메서드를 통해 값을 세팅하는데 이게 맞나..? 생성시점에는 Queue를 빈 LinkedList로 초기화하니까 불변객체는 맞는데... 뭔가 찜찜..
    @Test
    void test_setOperators_success() {
        List<String> validInputOperators = List.of("+", "-", "/", "*", "+");
        operators.setOperators(validInputOperators);

        assertThat(operators.getLength()).isEqualTo(validInputOperators.size());
    }

    // TODO : IllegalArgumentException를 던지는 부분은 Operator.enum에 있다... 이걸 여기서 체스트 하는게 맞을까? ( enum이라 의존성이 강결합되어있어서 모킹도 힘듬.. )
    @Test
    void test_setOperators_invalid_operators() {
        List<String> invalidInputOperators = List.of("+", "1", "2", "*", "+");
        assertThatThrownBy(() -> operators.setOperators(invalidInputOperators))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_setOperators_empty_operators() {
        List<String> emptyInputOperators = List.of();
        assertThatThrownBy(() -> operators.setOperators(emptyInputOperators))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_getNextOperator_success() {
        List<String> inputOperators = List.of("+", "-", "/", "*", "+");
        operators.setOperators(inputOperators);

        assertThat(operators.getNextOperator()).isEqualTo(Operator.findOperator(inputOperators.get(0)));
    }

    @Test
    void test_getNextOperator_empty_list() {
        List<String> inputOperators = List.of();
        operators.setOperators(inputOperators);

        assertThatThrownBy(() -> operators.getNextOperator())
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void test_operateAll_success() {
        List<String> inputOperators = List.of("+", "-");
        List<Integer> inputNumbers = List.of(4, 5, 3);
        operators.setOperators(inputOperators);

        int expect = 4 + 5 -3;
        int actual = operators.operateAll(inputNumbers);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test_operateAll_empty_numbers() {
        List<String> inputOperators = List.of("+", "-");
        List<Integer> inputNumbers = List.of();
        operators.setOperators(inputOperators);

        assertThatThrownBy(() -> operators.operateAll(inputNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
