import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  void 자동차는_이름을_갖는다() {
    final String name = "name";

    final Car car = new Car(name);

    assertThat(car.getName())
        .isEqualTo(name);
  }

  @Test
  void 자동차는_4가_넘으면_움직인다(){
    final FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
    final Car car = new Car("name", fixedNumberGenerator);

    car.move();

    assertThat(car.getPosition())
        .isEqualTo(1);
  }
}
