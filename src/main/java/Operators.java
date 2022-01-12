import java.util.List;

public interface Operators {

    void addOperator(String operatorStr);

    Operator getNextOperator();

    int operateAll(List<Integer> numbers);

    int getLength();

}
