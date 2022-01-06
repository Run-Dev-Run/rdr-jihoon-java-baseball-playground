import java.util.Scanner;

public class ConsoleInput implements Input{

    Scanner scanner = new Scanner(System.in);

    @Override
    public int inputNumber() {
        System.out.print(REQUEST_INPUT_NUMBER);

        return scanner.nextInt();
    }

}
