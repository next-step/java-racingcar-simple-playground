import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import io.suhan.racingcar.Car;
import io.suhan.racingcar.generator.FixedNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차는 이름을 가지고 있다.")
    void carHasName() {
        String name = "neo";

        Car car = new Car(name);

        assertEquals(name, car.getName());
    }

    @Test
    @DisplayName("생성된 값이 4 이상일 경우 자동차가 움직일 수 있다.")
    void carCanMove() {
        FixedNumberGenerator generator = new FixedNumberGenerator(4);
        Car car = new Car("neo", generator);

        car.move();

        int position = car.getPosition();

        assertNotEquals(0, position);
    }

    @Test
    @DisplayName("생성된 값이 3 이하일 경우 자동차가 멈춘다.")
    void carCanNotMove() {
        FixedNumberGenerator generator = new FixedNumberGenerator(3);
        Car car = new Car("neo", generator);

        car.move();

        int position = car.getPosition();

        assertEquals(0, position);
    }
}
