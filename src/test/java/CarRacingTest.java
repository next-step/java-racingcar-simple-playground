import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

  @Nested
  @DisplayName("RandomNumberGenerator 테스트")
  class RandomNumberGenerateTest {

    @Test
    @DisplayName("generate 메서드는 0에서 9사이의 정수를 반환한다.")
    void testGenerateMethodReturnZeroAndNine() {
      int randomNumber = 100;
      assertThat(randomNumber).isBetween(0, 9);
    }
  }

  @Nested
  @DisplayName("Car 기능 요구사항 테스트")
  class CarTest {

    @Test
    @DisplayName("자동차는 4이상의 값이면 전진하며 그 외의 경우에는 움직이지 않는다.")
    void testCarMove() {
      Car car = new Car("붕붕이");

      car.move();

      if (car.getRandomNumber() >= 4) {
        assertThat(car.getScore()).isEqualTo(1);
      }
      assertThat(car.getScore()).isEqualTo(0);
    }
  }

  @Nested
  @DisplayName("Car 이름 테스트")
  class CarNameTest {

    @Test
    @DisplayName("자동차 이름의 길이는 5이하여야 한다.")
    void testCarNameLength() {
      String carName = "A".repeat(6);

      assertThatThrownBy(() -> {
        Car car = new Car(carName);
      })
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Car name cannot be longer than 5 characters.");
    }

    @Test
    @DisplayName("자동차 이름은 공백일 수 없다.")
    void testCarNameBlank() {
      String carName = " ";

      assertThatThrownBy(() -> {
        Car car = new Car(carName);
      })
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Car name cannot be blank.");
    }
  }

  @Nested
  @DisplayName("Cars 기능 테스트")
  class CarsTest {

    @Test
    @DisplayName("자동차들의 최대 위치를 구할 수 있다.")
    void testCarsScore() {
      List<Car> cars = List.of(new Car("씽씽이", 4), new Car("붕붕이", 2));
      Cars racingCars = new Cars(cars);
      
      int maxScore = racingCars.getMaxScore();

      assertThat(maxScore).isEqualTo(4);
    }
  }
}

