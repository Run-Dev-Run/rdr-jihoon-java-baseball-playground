import java.util.Scanner;

public class ConsoleInput implements Input{

    Scanner scanner = new Scanner(System.in);

    @Override
    public int inputNumber() {
        System.out.print(REQUEST_INPUT_NUMBER_MESSAGE);

        return scanner.nextInt();
    }

    @Override
    public int inputCommandNumber() {
        System.out.print(GAME_CONTINUE_CONFIRM_MESSAGE);

        return scanner.nextInt();
    }

}
