import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
public class CarTest {

  @Test
  @DisplayName("이름 속성 확인")
  void testName() {
    Car car = new Car(new TestNumberGenerator(3), 0, "자동차1");

    String name = car.getName();

    assertThat(name).isEqualTo("자동차1");
  }

  @Test
  @DisplayName("숫자가 4이상일 때 자동차가 움직이는 지 테스트")
  void testMove() {
    Car car = new Car(new TestNumberGenerator(4),0, "자동차1");

    car.move();

    assertThat(car.getCoordinateX()).isEqualTo(1);
  }

  @Test
  @DisplayName("숫자가 3 이하일 때 자동차가 움직이지 않는 지 테스트")
  void testNotMove() {
    Car car = new Car(new TestNumberGenerator(3), 0, "자동차1");

    car.move();

    assertThat(car.getCoordinateX()).isEqualTo(0);
  }
}
