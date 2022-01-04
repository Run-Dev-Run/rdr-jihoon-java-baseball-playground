import static java.lang.Character.isDigit;

public class StringCalculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public Integer runCalculator(String value) {
        // 공백이 없는 형태로 변경 후 ""를 기준으로 나눈다.
        String[] values = value.trim()
            .replaceAll(" ", "")
            .split("");

        // 첫 자리가 숫자가 아니면 안됨
        if (!isDigit(values[0].charAt(0))) {
            throw new IllegalArgumentException();
        }

        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calculate(values[i], result, Integer.parseInt(values[i + 1]));
        }

        showResult(result);

        return result;
    }

    public Integer calculate(String operator, Integer leftValue, Integer rightValue) {

        if (operator.equals(PLUS)) {
            return leftValue += rightValue;
        }

        if (operator.equals(MINUS)) {
            return leftValue -= rightValue;
        }

        if (operator.equals(MULTIPLICATION)) {
            return leftValue *= rightValue;
        }

        if (operator.equals(DIVISION)) {
            return leftValue /= rightValue;
        }

        throw new IllegalArgumentException();
    }

    private void showResult(Integer result) {
        if (result == null) {
            System.out.println("계산에 실패했습니다.");
            return;
        }
        System.out.println("Result = " + result);
    }

}
