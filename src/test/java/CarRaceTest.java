import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceTest {
  int car_num = 15;
  int round_num = 10;
  CarRace carRace = new CarRace(car_num, round_num);

  @Test
  @DisplayName("자동차_이름_정하기")
  public void 자동차_이름_정하기() {
    for(int i = 0; i < car_num; i++) {
      carRace.setCarName(i, "푸앙이차" + (i+1));

      String actual = carRace.cars[i].name;
      String expected = "푸앙이차" + (i+1);

      assertThat(actual)
          .isEqualTo(expected);
    }
  }

  @Test
  @DisplayName("자동차_경주_시작하고_우승자_찾기")
  public void 자동차_경주_시작하고_우승자_찾기() {
    carRace.runRace();
    carRace.displayAllWinners();
  }

  @Test
  @DisplayName("자동차_이름_직접_정해서_경주하고_우승자_찾기")
  public void 자동차_이름_직접_정해서_경주하고_우승자_찾기() {
    for(int i = 0; i < car_num; i++) {
      carRace.setCarName(i, "푸앙이차" + (i + 1));
    }
    carRace.runRace();
    carRace.displayAllWinners();
  }
}