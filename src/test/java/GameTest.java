import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game(new ConsoleInput(), new ConsoleOutput());
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "45:false", "102:false"}, delimiter = ':')
    @DisplayName("validateInputNumber()는 0이 없는 3자리 수를 입력하면 true를 반환한다.")
    void test_validateInputNumber(int number, boolean expect) {
        boolean actual = game.validateInputNumber(number);

        assertThat(actual).isEqualTo(expect);
    }

}
