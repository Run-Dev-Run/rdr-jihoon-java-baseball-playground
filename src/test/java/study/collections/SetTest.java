package study.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("size()는 Set의 크기를 반환합니다.")
  void test_size() {
    int actual = numbers.size();

    assertThat(actual).isNotNull();
    assertThat(actual).isNotEqualTo(4); // Set은 중복을 허용하지 않는다.
    assertThat(actual).isEqualTo(3);
  }

  @DisplayName("contains()는 주어진 인자(param)의 존재여부를 반환합니다.")
  @ParameterizedTest(name ="{index} {displayName} param={0} ")
  @ValueSource(ints = {1,2,3})
  void test_contains(Integer param) {
    assertThat(numbers.contains(param)).isTrue();
  }

}
