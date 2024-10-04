import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

  @Nested
  @DisplayName("자동차 이동 테스트")
  class RacingCarMove {
    @Test
    @DisplayName("자동차 랜덤 이동 테스트")
    void randomMove() {
      RacingCar racingCar = new RacingCar("Test");
      int expected = racingCar.getScore();
      int actual = racingCar.move();

      assertThat(actual).isIn(expected, expected + 1);
    }

    @Test
    @DisplayName("자동차 이동 조건 테스트")
    void moveCondition() {
      RacingCar racingCar = new RacingCar("Test");
      int expected = 0;
      int actual = racingCar.move(3);

      assertThat(actual).isEqualTo(expected);

      expected = 1;
      actual = racingCar.move(5);

      assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이동 조건 예외처리 테스트")
    void moveConditionException() {
      RacingCar racingCar = new RacingCar("Test");

      assertThatThrownBy(() -> racingCar.move(-1)).isInstanceOf(IllegalArgumentException.class).hasMessage("0~9 사이의 Power 값을 필요로 합니다.");

      assertThatThrownBy(() -> racingCar.move(10)).isInstanceOf(IllegalArgumentException.class).hasMessage("0~9 사이의 Power 값을 필요로 합니다.");
    }
  }
  

  @Test
  @DisplayName("자동차 결과 텍스트 테스트")
  void racingCarResultString() {
    RacingCar racingCar = new RacingCar("Test");

    for (int i = 0; i < 5; ++i)
      racingCar.move();


    String actual = racingCar.getResultString(5);
    String expected = new String(new char[racingCar.getScore()]).replace("\0", "-");

    assertThat(actual).isEqualTo(expected);
  }

  @Nested
  @DisplayName("자동차 게임 설정 테스트")
  class SetRacingCarGameTest {
    @Test
    @DisplayName("자동차 이름 입력이 하나일 경우 테스트")
    void setGameWithLessThanTwoNameInput() {
      RacingCarGame racingCarGame = new RacingCarGame();
      System.setIn(new ByteArrayInputStream("test1\n1".getBytes()));

      assertThatThrownBy(racingCarGame::setGame).isInstanceOf(InputMismatchException.class).hasMessage("최소한 두 명 이상의 플레이어가 필요합니다.");
    }

    @Test
    @DisplayName("시도할 횟수 입력이 음수일 경우 테스트")
    void setGameWithNegativePhaseInput() {
      RacingCarGame racingCarGame = new RacingCarGame();
      System.setIn(new ByteArrayInputStream("test1,test2\n-1\n".getBytes()));

      assertThatThrownBy(racingCarGame::setGame).isInstanceOf(NumberFormatException.class).hasMessage("음수는 유효한 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("시도할 횟수 입력이 숫자가 아닌 경우 테스트")
    void setGameWithInvalidPhaseInput() {
      RacingCarGame racingCarGame = new RacingCarGame();
      System.setIn(new ByteArrayInputStream("test1,test2\nabc\n".getBytes()));

      assertThatThrownBy(racingCarGame::setGame).isInstanceOf(InputMismatchException.class).hasMessage("유효한 숫자가 아닙니다.");
    }
  }
}
