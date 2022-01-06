import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball computerBall;

    @BeforeEach
    public void setUp() {
        computerBall = new Ball(1, 3);
    }

    @Test
    @DisplayName("play()는 매개변수로 받은 Ball객체의 position과 number가 완전히 같을 경우 STRIKE를 반환한다.")
    void test_play_strike() {
        Ball userBall = new Ball(1, 3);
        BallStatus status = computerBall.play(userBall);

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("play()는 매개변수로 받은 Ball객체의 position은 다르지만 number가 같을 경우 BALL를 반환한다.")
    void test_play_ball() {
        Ball userBall = new Ball(2, 3);
        BallStatus status = computerBall.play(userBall);

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("play()는 매개변수로 받은 Ball객체의 position과 number가 둘다 다를 경우 NOTHING를 반환한다.")
    void test_play_nothing() {
        Ball userBall = new Ball(2, 4);
        BallStatus status = computerBall.play(userBall);

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}
