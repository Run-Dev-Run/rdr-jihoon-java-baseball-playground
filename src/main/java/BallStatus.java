public enum BallStatus {

    STRIKE, BALL, NOTHING;

    public static boolean isNotNothing(BallStatus status) {
        return status != BallStatus.NOTHING;
    }

    public static boolean isStrike(BallStatus status) {
        return status == BallStatus.STRIKE;
    }

    public static boolean isBall(BallStatus status) {
        return status == BallStatus.BALL;
    }

}
