import java.util.Objects;

public class Ball {

    private final int position;

    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public BallStatus compare(Ball userBall) {
        if (this.equals(userBall)) {
            return BallStatus.STRIKE;
        }

        if (position != userBall.getPosition() && number == userBall.getNumber()) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
