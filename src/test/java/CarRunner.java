import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarRunner {

  @Test
  @DisplayName("스피드가 3 이하면 자동차는 움직이지 않는다")
  void  notMoveWhenThreeOrLess(){
    Car car = new Car("Slow");
    for (int speed = 1; speed <= 3; speed++) {
      car.moveWithSpeed(speed);
      assertThat(car.getPosition()).isEqualTo(0);
    }
  }

  @Test
  @DisplayName("스피드가 4 이상이면 자동차는 움직인다")
  void moveWhenFourOrMore() {
    Car car = new Car("Fast");
    for (int speed = 4; speed <= 9; speed++) {
      int beforePosition = car.getPosition();
      car.moveWithSpeed(speed);
      assertThat(car.getPosition()).isEqualTo(beforePosition + speed);
    }
  }

  @Test
  @DisplayName("랜덤값은 0부터 9까지의 값을 생성한다")
  void generateRandomBetweenZeroAndNine() {
    Car car = new Car("랜덤");
    car.move();
    int speed = car.getLastSpeed();
    assertThat(speed).isBetween(0, 9);
  }
}
