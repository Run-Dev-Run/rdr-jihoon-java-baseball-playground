import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void test_calculate_strike() {
        score.calculate(BallStatus.STRIKE);

        assertThat(score.getStrikeCount()).isEqualTo(1);
        assertThat(score.getBallCount()).isEqualTo(0);
    }

    @Test
    void test_calculate_ball() {
        score.calculate(BallStatus.BALL);

        assertThat(score.getStrikeCount()).isEqualTo(0);
        assertThat(score.getBallCount()).isEqualTo(1);
    }

    @Test
    void test_calculate_nothing() {
        score.calculate(BallStatus.NOTHING);

        assertThat(score.getStrikeCount()).isEqualTo(0);
        assertThat(score.getBallCount()).isEqualTo(0);
    }

}
