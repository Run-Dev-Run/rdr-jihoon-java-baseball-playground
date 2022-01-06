public class ConsoleOutput implements Output{

    @Override
    public void showGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGameContinueConfirmMessage() {
        System.out.println(GAME_CONTINUE_CONFIRM_MESSAGE);
    }

    @Override
    public void showGameEndMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }

}
