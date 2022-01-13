public class Score {

    private int strikeCount;

    private int ballCount;

    public Score() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public Score(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void calculate(BallStatus status) {
        if (BallStatus.isStrike(status)) {
            plusStrikeCount();
        }

        if (BallStatus.isBall(status)) {
            plusBallCount();
        }
    }

    public String makeResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount > 0) {
            stringBuilder.append(ballCount + "Ball ");
        }

        if (strikeCount > 0) {
            stringBuilder.append(strikeCount + "Strike");
        }

        return stringBuilder.toString();
    }

    private void plusStrikeCount() {
        strikeCount++;
    }

    private void plusBallCount() {
        ballCount++;
    }

}
