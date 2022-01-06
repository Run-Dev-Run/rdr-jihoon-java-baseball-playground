public class BallNumber {
    public static final int MIN = 1;
    public static final int MAX = 9;
    private final int ballNumber;

    public BallNumber(int number) {
        validateNumber(number);
        this.ballNumber = number;
    }

    private void validateNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException();
        }
    }

}
