import java.util.Random;

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
        int inputNumber = inputPlayerNumber();

        // 2. 컴퓨터는 난수를 생성한다.
        int randomNumber = getRandomNumber();

        // 3. 각 입력 값을 비교하고 점수를 계산한다.

        // 4. 결과를 출력한다.

        // 5. 결과에 따라 알맞는 UI로 이동한다.
        // 5-1. 3 스트라이크라면 게임 Continue 메시지를 출력한다.
        // 5-2. 아니면 게임 다시시작

//        }

        output.showGameEndMessage();
    }

    private int inputPlayerNumber() {
        int inputNumber = 0;
        while (!validateInputNumber(inputNumber)) {
            inputNumber = input.inputNumber();
        }
        return inputNumber;
    }

    public int getRandomNumber() {
        int max = 1000;
        int min = 110;

        return new Random().nextInt((max - min) + 1) + min;
    }

    public boolean validateInputNumber(int inputNumber) {
        String inputNumberStr = String.valueOf(inputNumber);

        // 3자리가 아니거나 0이 포함되어 있다면 false
        if (inputNumberStr.length() != 3 || inputNumberStr.contains("0")) {
            return false;
        }

        return true;
    }

}
