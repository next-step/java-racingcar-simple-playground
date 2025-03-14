import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

class CarNameTest {

  @Test
  @DisplayName("자동차 이름이 null이면 예외가 발생한다")
  void throwExceptionWhenCarNameIsNull() {
    assertThatThrownBy(() -> new CarName(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다")
  void throwExceptionWhenCarNameIsBlack() {
    assertThatThrownBy(() -> new CarName(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  @DisplayName("자동차 이름이 5글자 이상이면 예외가 발생한다")
  void throwExceptionWhenExceedsFive() {
    assertThatThrownBy(() -> new CarName("abcdef"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  @DisplayName("자동차 이름이 1글자에서 5글자 사이면 정상적으로 생성된다")
  void createWhenCarNameIsBetween() {
    assertThat(new CarName("abc").getName()).isEqualTo("abc");
    assertThat(new CarName("a").getName()).isEqualTo("a");
    assertThat(new CarName("abcde").getName()).isEqualTo("abcde");
  }
}
