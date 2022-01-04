package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("replace()는 지정한 문자열을 다른 문자열로 교체한다.")
    void test_replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split()는 beginIndex 이상 endIndex 미만의 문자열을 잘라내서 반환한다.")
    void test_split() {
        // given
        String data = "(1,2)";
        int beginIndex = 1;
        int endIndex = 4;

        // when
        String actual = data.substring(beginIndex, endIndex);

        // then
        assertThat(actual).isEqualTo("1,2");
    }

}
