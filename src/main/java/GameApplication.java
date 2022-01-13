public class GameApplication {

    public static void main(String[] args) {
        GameInput consoleInput = new ConsoleInput();
        GameOutput consoleOutput = new ConsoleOutput();
        RandomNumberGenerator generator = new RandomNumberGenerator();

        Game game = new Game(generator, consoleInput, consoleOutput);
        game.start();
    }

}
