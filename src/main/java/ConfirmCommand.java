import java.util.Arrays;

public enum ConfirmCommand {
    CONTINUE(1),
    EXIT(2);

    int value;

    ConfirmCommand(int value) {
        this.value = value;
    }

    public static ConfirmCommand findConfirmCommand(String input) {
        return Arrays.stream(ConfirmCommand.values())
            .filter(confirmCommand -> confirmCommand.getValue() == Integer.parseInt(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 커맨드입니다."));
    }

    public int getValue() {
        return value;
    }

    public boolean isExit() {
        return this.equals(ConfirmCommand.EXIT);
    }

}
