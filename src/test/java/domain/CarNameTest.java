package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("자동차 이름이 null이거나 빈 문자열이면 예외가 발생한다")
  void throwExceptionWhenCarNameIsNullOrEmpty(String input) {
    assertThatThrownBy(() -> CarName.of(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  @DisplayName("자동차 이름이 6글자 이상이면 예외가 발생한다")
  void throwExceptionWhenExceedsFive() {
    assertThatThrownBy(() -> CarName.of("abcdef"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"a", "abc", "abcde"})
  @DisplayName("자동차 이름이 1글자에서 5글자 사이면 정상적으로 생성된다")
  void createWhenCarNameIsBetween(String input) {
    assertThat(CarName.of(input).getName()).isEqualTo(input);
  }
}
