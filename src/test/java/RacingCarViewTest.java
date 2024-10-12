import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import view.RacingCarView;
import view.RacingCarView.RacingCarInputException;

public class RacingCarViewTest {

  @Nested
  class InputRacingCarNameTest {
    @Test
    @DisplayName("자동차 이름 입력이 하나일 경우 테스트")
    void inputWithLessThanTwoName() {
      RacingCarView racingCarView = new RacingCarView();
      System.setIn(new ByteArrayInputStream("test1\n".getBytes()));

      assertThatThrownBy(racingCarView::inputRacingCarName).isInstanceOf(RacingCarInputException.class).hasMessage("최소한 두 명 이상의 플레이어가 필요합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 띄어쓰기가 있을 경우 테스트")
    void inputWithSpace() {
      RacingCarView racingCarView = new RacingCarView();
      System.setIn(new ByteArrayInputStream("test1, test2\n".getBytes()));

      assertThat(racingCarView.inputRacingCarName().stream().noneMatch(s -> s.contains(" "))).isTrue();
    }

    @Test
    @DisplayName("자동차 이름에 특수기호 있을 경우 테스트")
    void inputWithSpecialSymbol() {
      RacingCarView racingCarView = new RacingCarView();
      System.setIn(new ByteArrayInputStream("test1#,test2&\n".getBytes()));

      assertThatThrownBy(racingCarView::inputRacingCarName).isInstanceOf(RacingCarInputException.class).hasMessage("이름에 특수기호를 입력할 수 없습니다.");
    }
  }

  @Nested
  class InputRoundTest {
    @Test
    @DisplayName("시도할 횟수 입력이 음수일 경우 테스트")
    void inputWithNegativeNumber() {
      RacingCarView racingCarView = new RacingCarView();
      System.setIn(new ByteArrayInputStream("-1\n".getBytes()));

      assertThatThrownBy(racingCarView::inputRound).isInstanceOf(RacingCarInputException.class).hasMessage("횟수는 1회 이상이여야 합니다.");
    }

    @Test
    @DisplayName("시도할 횟수 입력이 숫자가 아닌 경우 테스트")
    void inputWithInvalidCharacter() {
      RacingCarView racingCarView = new RacingCarView();
      System.setIn(new ByteArrayInputStream("abc\n".getBytes()));

      assertThatThrownBy(racingCarView::inputRound).isInstanceOf(RacingCarInputException.class).hasMessage("유효하지 않은 입력입니다.");
    }
  }

}
