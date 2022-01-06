public interface Output {

    String GAME_START_MESSAGE = "게임을 시작합니다.";
    String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String GAME_CONTINUE_CONFIRM_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    void showGameStartMessage();

    void showMessage(String message);

    void showGameContinueConfirmMessage();

    void showGameEndMessage();

}
