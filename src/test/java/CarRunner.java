import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarRunner {

  @Test
  void 스피드가_3이하면_자동차는_움직이지_않는다() {
    Car car = new Car("Slow");
    for (int speed = 1; speed <= 3; speed++) {
      car.moveWithSpeed(speed);
      assertThat(car.getPosition()).isEqualTo(0);
    }
  }

  @Test
  void 스피드가_4이상이면_자동차는_움직인다() {
    Car car = new Car("Fast");
    for (int speed = 4; speed <= 9; speed++) {
      int beforePosition = car.getPosition();
      car.moveWithSpeed(speed);
      assertThat(car.getPosition()).isEqualTo(beforePosition + speed);
    }
  }

  @Test
  void 랜덤값은_0부터_9까지의_값을_생성한다() {
    Car car = new Car("랜덤");
    car.move();
    int speed = car.getLastSpeed();
    assertThat(speed).isBetween(0, 9);
  }
}
