import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.FixedNumberGenerator;
import domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarRunnerTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("스피드가 3 이하면 자동차는 움직이지 않는다")
  void notMoveWhenThreeOrLess(int speed) {
    Car car = new Car("Slow", new FixedNumberGenerator(speed));
    car.move();
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  @DisplayName("스피드가 4 이상이면 자동차는 움직인다")
  void moveWhenFourOrMore(int speed) {
    Car car = new Car("Fast", new FixedNumberGenerator(speed));
    int beforePosition = car.getPosition();
    car.move();
    assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
  }

  @Test
  @DisplayName("랜덤값은 0부터 9까지의 값을 생성한다")
  void generateRandomBetweenZeroAndNine() {
    Car car = new Car("랜덤", new RandomNumberGenerator());
    car.move();
    int speed = car.getLastSpeed();
    assertThat(speed).isBetween(0, 9);
  }
}
