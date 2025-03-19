import static org.assertj.core.api.Assertions.assertThatThrownBy;

import controller.CarRunner;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputViewTest {

  @Test
  @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
  void throwExceptionWhenAttemptsLessThenOne() {
    assertThatThrownBy(() -> CarRunner.validateAttempts(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도 횟수는 1 이상이어야 합니다.");
  }

  @Test
  @DisplayName("자동차 대수가 2 이하면 예외가 발생한다")
  void throwExceptionWhenCarCountOneOrLess() {
    assertThatThrownBy(() -> CarRunner.validateCarCount(1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("경주에는 최소 2대의 자동차가 필요합니다.");
  }
}
