import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    private final int MAX = 9;

    private final int MIN = 1;

    private RandomNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
    }

    @Test
    void test_generate() {
        int randomNumber = generator.generate();
        assertThat(randomNumber).isBetween(MIN, MAX);
        assertThat(randomNumber).isNotNull();
    }

}
