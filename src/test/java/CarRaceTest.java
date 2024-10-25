import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

  final int roundNum = 10;
  final String carNames = "neo,brie,brown";
  final CarRace carRace = new CarRace(roundNum, carNames);

  @Test
  @DisplayName("자동차_경주_우승자_찾기")
  public void 자동차_경주_우승자_찾기() {
    carRace.runRace(carRace.getRandNum());
    carRace.displayAllWinners();

    String expected = carRace.getWinnersName().toString();
    String actual = carRace.getCoWinners().toString();

    assertThat(actual)
        .isEqualTo(expected);
  }
}