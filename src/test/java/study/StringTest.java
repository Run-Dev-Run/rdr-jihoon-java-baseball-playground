package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

  @Test
  @DisplayName("charAt()는 지정한 index에 해당하는 문자를 char형으로 반환한다.")
  void test_charAt_success() {
    // given
    String data = "abc";
    int index = 1;

    // when
    char actual = data.charAt(index);

    // then
    assertThat(actual).isEqualTo('b');
  }

  @Test
  @DisplayName("charAt()는 지정한 index가 문자열의 길이를 벗어나면 IndexOutOfBoundsException를 던집니다.")
  void test_charAt_IndexOutOfBoundsException() {
    // given
    String data = "abc";
    int outOfIndex = data.length() + 2;

    // when
    // then
    assertThatThrownBy(() -> data.charAt(outOfIndex))
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: " + outOfIndex);
  }

}
