import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class RaceInputTest {

  @Test
  void 자동차_대수가_1이하이면_예외가_발생한다() {
    Scanner scanner = new Scanner("1\n");
    RaceInput raceInput = new RaceInput(scanner);
    assertThatThrownBy(raceInput::getCarCount)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 대수는 2 이상이어야 합니다.");
  }

  @Test
  void 시도_횟수가_1이하이면_예외가_발생한다() {
    Scanner scanner = new Scanner("0\n");
    RaceInput raceInput = new RaceInput(scanner);

    assertThatThrownBy(raceInput::getAttempts)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도 횟수는 1 이상이어야 합니다.");
  }
}
