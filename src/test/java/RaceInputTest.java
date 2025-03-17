import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceInputTest {

  @Test
  @DisplayName("자동차 대수가 1 이하면 예외가 발생한다")
  void throwExceptionWhenCarCountOneOrLess() {
    Scanner scanner = new Scanner("1\n");
    RaceInput raceInput = new RaceInput(scanner);
    assertThatThrownBy(raceInput::getCarCount)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 대수는 2 이상이어야 합니다.");
  }

  @Test
  @DisplayName("시도 횟수가 1 이하면 예외가 발생한다")
  void throwExceptionWhenAttemptsTwoOrLess() {
    Scanner scanner = new Scanner("0\n");
    RaceInput raceInput = new RaceInput(scanner);

    assertThatThrownBy(raceInput::getAttempts)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도 횟수는 1 이상이어야 합니다.");
  }
}
