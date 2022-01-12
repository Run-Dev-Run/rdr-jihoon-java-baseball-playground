import java.util.List;

public interface Operators {

    void setOperators(List<String> operatorStrArr);

    Operator getNextOperator();

    int operateAll(List<Integer> numbers);

    int getLength();

}
