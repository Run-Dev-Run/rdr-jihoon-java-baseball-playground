public class Score {

    private int strikeCount;

    private int ballCount;


    public Score() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            plusStrikeCount();
        }

        if (status.isBall()) {
            plusBallCount();
        }

    }

    private void plusStrikeCount() {
        strikeCount+=1;
    }

    private void plusBallCount() {
        ballCount+=1;
    }

}
