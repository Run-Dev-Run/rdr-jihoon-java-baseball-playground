public class StringCalculatorApplication {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Operators operators = new OperatorsQueue();
        InputNumbers inputNumbers = new InputNumbersList();

        Calculator calculator = new Calculator(input, output, operators, inputNumbers);
        calculator.calculate();
    }

}
