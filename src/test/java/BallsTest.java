import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private Balls computerBalls;

    @BeforeEach
    public void setUp() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_nothing() {
        Score score = computerBalls.play(Arrays.asList(4, 5, 6));
        assertThat(score.getStrikeCount()).isEqualTo(0);
        assertThat(score.getBallCount()).isEqualTo(0);
    }

    @Test
    void play_3strike() {
        Score score = computerBalls.play(Arrays.asList(1, 2, 3));
        assertThat(score.getStrikeCount()).isEqualTo(3);
        assertThat(score.getBallCount()).isEqualTo(0);
    }

    @Test
    void play_1strike_2ball() {
        Score score = computerBalls.play(Arrays.asList(3, 2, 1));
        assertThat(score.getStrikeCount()).isEqualTo(1);
        assertThat(score.getBallCount()).isEqualTo(2);
    }

    @Test
    void strike() {
        Ball userBall = new Ball(1, 2);
        BallStatus status = computerBalls.play(userBall);

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball userBall = new Ball(1, 3);
        BallStatus status = computerBalls.play(userBall);

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball userBall = new Ball(1, 4);
        BallStatus status = computerBalls.play(userBall);

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}
