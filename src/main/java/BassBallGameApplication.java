public class BassBallGameApplication {

    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        Output output = new ConsoleOutput();

        Game game = new Game(consoleInput, output);
        game.start();
    }

}
