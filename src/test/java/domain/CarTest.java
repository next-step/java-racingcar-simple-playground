package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("스피드가 3 이하면 자동차는 움직이지 않는다")
  void notMoveWhenThreeOrLess(int speed) {
    // given
    Car car = new Car("Slow", new TestNumberGenerator(new int[]{speed}));

    // when
    car.move();

    // then
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  @DisplayName("스피드가 4 이상이면 자동차는 움직인다")
  void moveWhenFourOrMore(int speed) {
    // given
    Car car = new Car("Fast", new TestNumberGenerator(new int[]{speed}));
    int beforePosition = car.getPosition();

    // when
    car.move();

    // then
    assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
  }

  @Test
  @DisplayName("랜덤값은 0부터 9까지의 값을 생성한다")
  void generateRandomBetweenZeroAndNine() {
    // given
    Car car = new Car("랜덤", new RandomNumberGenerator());

    // when
    car.move();

    // then
    int speed = car.getLastSpeed();
    assertThat(speed).isBetween(0, 9);
  }
}
