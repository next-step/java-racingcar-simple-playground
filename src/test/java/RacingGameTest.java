import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {

  @Test
  @DisplayName("자동차 참여 테스트")
  void testCarJoin() {
    Car car1 = new Car(new TestNumberGenerator(3), 0, "자동차1");
    Car car2 = new Car(new TestNumberGenerator(4), 0, "자동차2");

    RacingGame game1 = new RacingGame();

    game1.addCar(car1);
    game1.addCar(car2);

    assertThat(game1.getCurrentCarCount()).isEqualTo(2);
  }

  @Test
  @DisplayName("우승자 확인 테스트")
  void testRacingWinner() {
    Car car1 = new Car(new TestNumberGenerator(3), 0, "자동차1");
    Car car2 = new Car(new TestNumberGenerator(4), 0, "자동차2");

    RacingGame game1 = new RacingGame();
    game1.addCar(car1);
    game1.addCar(car2);

    game1.proceedGame();

    List<String> winnerNames = game1.getWinners();

    assertThat(winnerNames).containsExactlyInAnyOrderElementsOf(List.of("자동차2"));
  }

  @Test
  @DisplayName("복수 우승자 확인 테스트")
  void testMultipleWinner() {
    Car car0 = new Car(new TestNumberGenerator(3), 0, "자동차0");
    Car car1 = new Car(new TestNumberGenerator(3), 0, "자동차1");
    Car car2 = new Car(new TestNumberGenerator(4), 0, "자동차2");
    Car car3 = new Car(new TestNumberGenerator(4), 0, "자동차3");

    RacingGame game1 = new RacingGame();
    game1.addCar(car0);
    game1.addCar(car1);
    game1.addCar(car2);
    game1.addCar(car3);

    game1.proceedGame();

    List<String> winnerNames = game1.getWinners();

    assertThat(winnerNames).containsExactlyInAnyOrderElementsOf(List.of("자동차3", "자동차2"));
  }
}
