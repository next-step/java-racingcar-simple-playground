import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {

  @Test
  @DisplayName("자동차 참여 테스트")
  void testCarJoin() {
    Car car1 = new Car(0, "자동차1");
    Car car2 = new Car(0, "자동차2");

    RacingGame game1 = new RacingGame();

    game1.addCar(car1);
    game1.addCar(car2);

    assertThat(game1.getCurrentCarCount()).isEqualTo(2);
  }
}
