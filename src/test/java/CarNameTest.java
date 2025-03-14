import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

  @Test
  void 자동차_이름이_null이면_예외가_발생한다() {
    assertThatThrownBy(() -> new CarName(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  void 자동차_이름이_빈_문자열이면_예외가_발생한다() {
    assertThatThrownBy(() -> new CarName(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  void 자동차_이름이_5글자_이상이면_예외가_발생한다() {
    assertThatThrownBy(() -> new CarName("abcdef"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 1글자에서 5글자 사이여야 합니다.");
  }

  @Test
  void 자동차_이름이_1글자에서_5글자_사이면_정상적으로_생성된다() {
    assertThat(new CarName("abc").getName()).isEqualTo("abc");
    assertThat(new CarName("a").getName()).isEqualTo("a");
    assertThat(new CarName("abcde").getName()).isEqualTo("abcde");
  }
}
