import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OperatorsQueue implements Operators {

    private Queue<Operator> operators;

    public OperatorsQueue() {
        operators = new LinkedList<>();
    }

    public Queue<Operator> getOperators() {
        return operators;
    }

    @Override
    public void addOperator(String operatorStr) {
        if (operatorStr.isEmpty()) {
            throw new IllegalArgumentException("연산자가 없습니다.");
        }
        operators.add(Operator.findOperator(operatorStr));
    }

    @Override
    public Operator getNextOperator() {
        Operator operator = operators.poll();
        if (operator == null) {
            throw new RuntimeException("더이상 연산자가 없습니다.");
        }
        return operator;
    }

    @Override
    public int operateAll(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("계산할 값이 없습니다.");
        }
        return numbers.stream()
            .reduce((preNum, postNum) -> getNextOperator().operate(preNum, postNum))
            .orElseThrow(() -> new RuntimeException("계산에 실패하였습니다."));
    }

    @Override
    public int getLength() {
        return operators.size();
    }

}
