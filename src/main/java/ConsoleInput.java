import java.util.Scanner;

public class ConsoleInput implements Input{

    private final String REQUEST_INPUT_MESSAGE = "계산식을 입력해주세요";

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String inputFormula() {
        System.out.println(REQUEST_INPUT_MESSAGE);
        return scanner.nextLine();
    }

}
