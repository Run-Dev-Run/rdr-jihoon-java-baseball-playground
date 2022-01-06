public interface Output {

    String GAME_START_MESSAGE = "게임을 시작합니다.";
    String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    void showGameStartMessage();

    void showMessage(String message);

    void showGameEndMessage();

}
