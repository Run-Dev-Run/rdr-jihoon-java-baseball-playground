import java.util.ArrayList;
import java.util.List;

public class InputNumbers {

    private final List<InputNumber> inputNumbers;

    public InputNumbers() {
        inputNumbers = new ArrayList<>();

    }

    // TODO : getter가 있어도 될까?
    public List<InputNumber> getInputNumbers() {
        return inputNumbers;
    }

    public void addInputNumber(int number) {
        validateDuplicatedInputNumber(number);
        inputNumbers.add(new InputNumber(number));
    }

    private void validateDuplicatedInputNumber(int number) {
        if (inputNumbers.isEmpty()) {
            return;
        }

        boolean isDuplicated = inputNumbers.stream()
            .anyMatch(inputNumber -> inputNumber.getNumber() == number);

        if (isDuplicated) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

}
