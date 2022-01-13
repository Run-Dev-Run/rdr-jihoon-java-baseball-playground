public class Game {

    public static final int MAX_NUMBER_COUNT = 3;
    private final RandomNumberGenerator generator;

    private final GameInput input;

    private final GameOutput output;

    public Game(RandomNumberGenerator generator, GameInput input, GameOutput output) {
        this.generator = generator;
        this.input = input;
        this.output = output;
    }

    public void start() {

        // 랜덤 숫자 3개 입력받기 By Computer
        InputNumbers computerInputNumbers = getRandomNumbers();

        while (true) {
            // 숫자 3개를 입력받는다. By User
            InputNumbers userInputNumbers = input.getUserInputNumbers();

            // 입력받은 두 값을 비교해서 점수를 계산한다.
            Balls computerBalls = new Balls(computerInputNumbers);
            Score score = computerBalls.play(userInputNumbers);

            // 결과를 출력한다.
            output.output(score.makeResultMessage());

            // 결과에 따라 UI를 이동한다.
            if (score.getStrikeCount() != 3) {
                continue;
            }

            output.confirmMessage();

            ConfirmCommand confirmCommand = input.inputConfirmCommand();
            if (confirmCommand.isExit()) {
                return;
            }

            start(); // 재귀사용
            return;
        }

    }

    private InputNumbers getRandomNumbers() {
        InputNumbers inputNumbers = new InputNumbers();
        while (inputNumbers.getInputNumbers().size() < MAX_NUMBER_COUNT) {
            try {
                inputNumbers.addInputNumber(generator.generate());
            } catch (IllegalArgumentException e) { }
        }
        return inputNumbers;
    }

}
