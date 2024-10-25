import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

  final String carNames = "neo,brie,brown";

  @Test
  @DisplayName("자동차_경주_우승자_찾기")
  public void 자동차_경주_우승자_찾기() {
    final int roundNum = 10;
    final CarRace carRace = new CarRace(roundNum, carNames);
    carRace.runRace();
    carRace.displayAllWinners();

    String expected = carRace.getWinnersName().toString();
    String actual = carRace.getCoWinners().toString();

    assertThat(actual)
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("숫자_4이상일_때_자동차_경주_테스트")
  public void 숫자_4이상일_때_자동차_경주_테스트() {
    final int roundNum = 1;
    final CarRace carRace = new CarRace(roundNum, carNames);
    carRace.carMove(4);

    int expected = 1;
    int actual = carRace.getDistance(2);

    assertThat(actual)
      .isEqualTo(expected);
  }

  @Test
  @DisplayName("숫자_3이하일_때_자동차_경주_테스트")
  public void 숫자_3이하일_때_자동차_경주_테스트() {
    final int roundNum = 1;
    final CarRace carRace = new CarRace(roundNum, carNames);
    carRace.carMove(3);

    int expected = 0;
    int actual = carRace.getDistance(2);

    assertThat(actual)
        .isEqualTo(expected);
  }
}