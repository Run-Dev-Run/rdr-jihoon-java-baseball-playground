public abstract class GameOutput {

    public static final String GAME_EXIT_OR_CONTINUE_CONFIRM_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void confirmMessage() {
        output(GAME_EXIT_OR_CONTINUE_CONFIRM_MESSAGE);
    }

    protected abstract void output(String message);

}
