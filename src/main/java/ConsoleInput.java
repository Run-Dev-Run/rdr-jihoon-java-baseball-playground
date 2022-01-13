import java.util.Scanner;

public class ConsoleInput extends GameInput{

    public static final String REQUEST_INPUT_NUMBERS_MESSAGE = "숫자를 입력해 주세요. : ";

    private Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String input() {
        System.out.print(REQUEST_INPUT_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

}
