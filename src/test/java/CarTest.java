import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차는_이름을_가지고_있다() {
        String name = "name";
        Car car = new Car(name);

        assertThat(car.getName())
                .isEqualTo(name);
    }

    @Test
    void 자동차는_4가_넘으면_움직인다() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
        Car car = new Car("name", fixedNumberGenerator);

        car.move();

        assertThat(car.getLocation())
                .isEqualTo(1);
    }
}
