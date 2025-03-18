import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import CarGame2.Car;
import CarGame2.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차는 4이상일 경우에만 전진해야 한다.")
    void move_forward_if_speed_is_more_than_speed() {
        Generator fixedGenerator = () -> 4;
        Car car = new Car("testCar", fixedGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차는 4미만일 경우에는 정지해야한다.")
    void stay_if_speed_is_less_than_speed() {
        Generator fixedGenerator = () -> 3;
        Car car = new Car("testCar", fixedGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
