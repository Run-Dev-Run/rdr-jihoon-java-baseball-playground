public interface Input {

    String REQUEST_INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요(3자리) : ";
    String GAME_CONTINUE_CONFIRM_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    int inputNumber();

    int inputCommandNumber();

}
