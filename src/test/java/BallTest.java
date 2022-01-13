import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void test_nothing() {
        Ball userBall = new Ball(1,3);
        Ball computerBall = new Ball(1,2);

        BallStatus status = computerBall.compare(userBall);

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void test_strike() {
        Ball userBall = new Ball(1,3);
        Ball computerBall = new Ball(1,3);

        BallStatus status = computerBall.compare(userBall);

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void test_ball() {
        Ball userBall = new Ball(1,3);
        Ball computerBall = new Ball(2,3);

        BallStatus status = computerBall.compare(userBall);

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

}
