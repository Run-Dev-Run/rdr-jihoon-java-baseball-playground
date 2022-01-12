import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumbersList implements InputNumbers {

    private List<InputNumber> inputNumbers = new ArrayList<>();

    @Override
    public void addInputNumber(String inputNumberStr) {
        if (inputNumberStr.isEmpty()) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
        inputNumbers.add(new InputNumber(inputNumberStr));
    }

    @Override
    public List<Integer> convertToList() {
        return inputNumbers.stream()
            .map(InputNumber::getNumber)
            .collect(Collectors.toList());
    }

    @Override
    public int getLength() {
        return inputNumbers.size();
    }

}
