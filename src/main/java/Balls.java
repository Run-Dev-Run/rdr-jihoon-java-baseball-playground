import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {

    private final List<Ball> balls;

    public Balls(InputNumbers inputNumbers) {
        balls = new ArrayList<>();

        validateInputNumbers(inputNumbers);
        convertToBalls(inputNumbers);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private void validateInputNumbers(InputNumbers inputNumbers) {
        if (Objects.isNull(inputNumbers)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void convertToBalls(InputNumbers inputNumbers) {
        List<InputNumber> inputNumberList = inputNumbers.getInputNumbers();
        for (int i = 0; i < inputNumberList.size(); i++) {
            balls.add(new Ball(i, inputNumberList.get(i).getNumber()));
        }
    }

    public Score play(InputNumbers userInputNumbers) {
        Score score = new Score();

        Balls userBalls = new Balls(userInputNumbers);
        if (this.balls.equals(userBalls)) {
            return new Score(3, 0);
        }

        for (Ball userBall:  userBalls.getBalls()) {
            BallStatus status = compareWithUserBall(userBall);
            score.calculate(status);
        }

        return score;
    }

    private BallStatus compareWithUserBall(Ball userBall) {
        return balls.stream()
            .map(ball -> ball.compare(userBall))
            .filter(BallStatus::isNotNothing)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balls balls1 = (Balls) o;
        return balls.equals(balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

}
