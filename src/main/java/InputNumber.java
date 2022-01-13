public class InputNumber {

    private final int MAX = 9;

    private final int MIN = 1;

    private final int number;

    public InputNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        if (number > MAX || number < MIN) {
            throw new IllegalArgumentException("입력된 숫자가 유효하지 않습니다.");
        }
    }

}
