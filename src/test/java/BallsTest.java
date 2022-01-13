import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallsTest {

    private final List<Integer> COMPUTER_INPUT_NUMBERS = List.of(1, 2, 3);
    private Balls computerBalls;

    @BeforeEach
    void setUp() {
        InputNumbers inputNumbers = new InputNumbers();
        COMPUTER_INPUT_NUMBERS.forEach(inputNumbers::addInputNumber);

        computerBalls = new Balls(inputNumbers);
    }

    @Test
    void test_3strike() {
        InputNumbers inputNumbers = new InputNumbers();
        for (Integer computerInputNumber : COMPUTER_INPUT_NUMBERS) {
            inputNumbers.addInputNumber(computerInputNumber);
        }

        Score userScore = computerBalls.play(inputNumbers);

        assertThat(userScore.getStrikeCount()).isEqualTo(3);
        assertThat(userScore.getBallCount()).isEqualTo(0);
    }

    @Test
    void test_1strike_1ball() {
        List<Integer> userInputNumberList = List.of(1, 5, 2);
        InputNumbers inputNumbers = new InputNumbers();
        userInputNumberList.forEach(inputNumbers::addInputNumber);

        Score userScore = computerBalls.play(inputNumbers);

        assertThat(userScore.getStrikeCount()).isEqualTo(1);
        assertThat(userScore.getBallCount()).isEqualTo(1);
    }

    @Test
    void test_nothing() {
        List<Integer> userInputNumberList = List.of(4, 5, 6);
        InputNumbers inputNumbers = new InputNumbers();
        userInputNumberList.forEach(inputNumbers::addInputNumber);

        Score userScore = computerBalls.play(inputNumbers);

        assertThat(userScore.getStrikeCount()).isEqualTo(0);
        assertThat(userScore.getBallCount()).isEqualTo(0);
    }

}
