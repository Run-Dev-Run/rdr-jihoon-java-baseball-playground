public class Game {

    private Input input;

    private Output output;

    private Score score;

    public Game(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        output.showGameStartMessage();

//        while (true) {
            score = new Score();

            // 1. 플레이어는 숫자를 입력한다.
            int inputNumber = input.inputNumber();

            // 2. 컴퓨터는 난수를 생성한다.

            // 3. 각 입력 값을 비교하고 점수를 계산한다.

            // 4. 결과를 출력한다.

            // 5. 결과에 따라 알맞는 UI로 이동한다.
            // 5-1. 3 스트라이크라면 게임 Continue 메시지를 출력한다.
            // 5-2. 아니면 게임 다시시작

//        }

        output.showGameEndMessage();
    }

}
