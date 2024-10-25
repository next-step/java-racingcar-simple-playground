import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

  int roundNum = 10;
  String carNames = "neo,brie,brown";
  CarRace carRace = new CarRace(roundNum, carNames);

  @Test
  @DisplayName("자동차_경주_시작하고_우승자_찾기")
  public void 자동차_경주_시작하고_우승자_찾기() {
    carRace.runRace();
    carRace.displayAllWinners();
  }
}