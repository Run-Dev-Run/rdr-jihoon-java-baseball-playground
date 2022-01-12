import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Calculator {

    private final String DELIMETER = " ";

    private final Input input;

    private final Output output;

    private final Operators operators;

    private final InputNumbers inputNumbers;

    public Calculator(Input input, Output output, Operators operators, InputNumbers inputNumbers) {
        this.input = input;
        this.output = output;
        this.operators = operators;
        this.inputNumbers = inputNumbers;
    }

    public void runCalculator() {
        String formula = input.inputFormula();

        List<String> splittedStrings = Arrays.stream(formula.split(DELIMETER))
            .collect(Collectors.toList());

        validateInputFormula(splittedStrings);

        Queue<String> queue = new LinkedList<>(splittedStrings);
        for (int i = 0; i < splittedStrings.size(); i++) {
            separateQueueData(queue, i);
        }

        int result = operators.operateAll(inputNumbers.convertToList());

        output.showResult(result);
    }

    private void validateInputFormula(List<String> splitStrings) {
        if (splitStrings.size() % 2 == 0) {
            throw new IllegalArgumentException("계산식이 올바르지 않습니다.");
        }
    }

    private void separateQueueData(Queue<String> queue, int position) {
        if (position % 2 == 0) {
            inputNumbers.addInputNumber(queue.poll());
        } else {
            operators.addOperator(queue.poll());
        }
    }

}
