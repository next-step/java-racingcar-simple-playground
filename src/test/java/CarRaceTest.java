import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

  int car_num = 15;
  int round_num = 10;
  CarRace carRace = new CarRace(car_num, round_num);

  @Test
  @DisplayName("자동차_경주_시작하고_우승자_찾기")
  public void 자동차_경주_시작하고_우승자_찾기() {
    carRace.runRace();
    carRace.displayAllWinners();
  }
}