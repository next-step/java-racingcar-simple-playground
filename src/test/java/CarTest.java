import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_forward_when_number_is_four_or_more() {
        Car car = new Car("pobi", 0);

        car.moveCar(4);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void stop_when_number_is_three_or_less() {
        Car car = new Car("pobi", 0);

        car.moveCar(3);

        assertThat(car.getLocation()).isZero();
    }
}
