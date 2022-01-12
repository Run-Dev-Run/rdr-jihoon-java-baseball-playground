import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int operate(int preNumber, int postNumber) {
            return preNumber + postNumber;
        }
    },
    MINUS("-") {
        @Override
        public int operate(int preNumber, int postNumber) {
            return preNumber - postNumber;
        }
    },
    MULTIPLE("*") {
        @Override
        public int operate(int preNumber, int postNumber) {
            return preNumber * postNumber;
        }
    },
    DIVISION("/") {
        @Override
        public int operate(int preNumber, int postNumber) {
            if (postNumber <= 0) {
                throw new ArithmeticException("0 이하로는 나눌 수 없습니다.");
            }
            return preNumber / postNumber;
        }
    };

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operator findOperator(String operatorStr) {
        return Arrays.stream(Operator.values())
            .filter(operator -> operator.getValue().equals(operatorStr))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("입력된 연산자가 부정확합니다."));
    }

    public abstract int operate(int preNumber, int postNumber);

}
