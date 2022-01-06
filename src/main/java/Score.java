public class Score {

    private int strikeCount;

    private int ballCount;

    public Score() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void calculateScore(int inputNumber, int randomNumber) {

        if (inputNumber == randomNumber) {
            strikeCount = 3;
            return;
        }

        String inputNumberStr = String.valueOf(inputNumber);
        String randomNumberStr = String.valueOf(randomNumber);

        for (int i = 0; i < inputNumberStr.length(); i++) {
            String keyword = String.valueOf(inputNumberStr.charAt(i));
            checkHasBallOrStrike(randomNumberStr, i, keyword);
        }

    }

    public String getResultString() {
        StringBuilder resultStr = new StringBuilder("");

        if (ballCount > 0) {
            resultStr.append(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            resultStr.append(strikeCount + "스트라이크");
        }

        return resultStr.toString();
    }
    private void checkHasBallOrStrike(String randomNumberStr, int index, String keyword) {
        int foundIndex = randomNumberStr.indexOf(keyword);

        if (foundIndex < 0) {
            return;
        }

        if (foundIndex != index) {
            ballCount++;
            return;
        }

        strikeCount++;
    }

}
