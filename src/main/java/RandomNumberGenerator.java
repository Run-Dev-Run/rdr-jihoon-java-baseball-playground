import java.util.Random;

public class RandomNumberGenerator {

    private final int MAX = 9;

    private final int MIN = 1;

    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt((MAX - MIN) + 1) + MIN;
    }

}
