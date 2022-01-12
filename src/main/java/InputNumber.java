public class InputNumber {

    private int number;

    public InputNumber(String numberStr) {
        validateNumberStr(numberStr);
        number = Integer.parseInt(numberStr);
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberStr(String numberStr) {
        if (numberStr.isBlank() || !Character.isDigit(numberStr.charAt(0))) {
            throw new IllegalArgumentException("잘못된 형식의 숫자가 입력되었습니다.");
        }
    }

}
