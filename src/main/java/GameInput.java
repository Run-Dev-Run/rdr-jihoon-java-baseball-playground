import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GameInput {

    public static final String REQUEST_RE_INPUT_MESSAGE = "다시 입력해주세요.";

    public InputNumbers getUserInputNumbers() {

        String inputStr = inputStr = input();
        List<Integer> inputs = convertToIntegerList(inputStr);

        InputNumbers inputNumbers = null;
        try {
            inputNumbers = new InputNumbers(inputs);

        } catch (IllegalArgumentException e) {
            System.out.println(REQUEST_RE_INPUT_MESSAGE);
            getUserInputNumbers();
        }

        return inputNumbers;
    }

    public ConfirmCommand inputConfirmCommand() {
        ConfirmCommand confirmCommand = null;

        try {
            confirmCommand = ConfirmCommand.findConfirmCommand(input());
        } catch (IllegalArgumentException e) {
            System.out.println(REQUEST_RE_INPUT_MESSAGE);
            inputConfirmCommand();
        }

        return confirmCommand;
    }

    private List<Integer> convertToIntegerList(String inputStr) {
        return Arrays.stream(inputStr.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    protected abstract String input();

}
