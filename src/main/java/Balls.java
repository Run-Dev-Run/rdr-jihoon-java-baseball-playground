import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> ballNumbers) {
        convertToBallList(ballNumbers);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Score play(List<Integer> ballNumbers) {
        Balls userBalls = new Balls(ballNumbers);
        Score score = new Score();

        for (Ball ball : userBalls.getBalls()) {
            BallStatus status = play(ball);
            score.report(status);
        }

        return score;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
            .map(ball -> ball.play(userBall))
            .filter(ballStatus -> !ballStatus.isNothing())
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    private void convertToBallList(List<Integer> ballNumbers) {
        for (int i = 0; i < ballNumbers.size(); i++) {
            balls.add(new Ball(i, ballNumbers.get(i)));
        }
    }

}
