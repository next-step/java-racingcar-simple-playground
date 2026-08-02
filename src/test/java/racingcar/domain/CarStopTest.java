package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarStopTest {
    public static final int CAR_STOP_NUMBER_THRESHOLD = 3;
    Car car = new Car("Car1");
    CarStopNumberGenerator carStopNumberGenerator = new CarStopNumberGenerator();

    @Test
    @DisplayName("자동차는 전진하지 않고 기존 위치에 멈춰있다.")
    void carNotMovingTest() {
        car.moveCar(carStopNumberGenerator.makeNum());

        assertEquals(0, car.getLocation());
    }

    @Test
    @DisplayName("무작위 값이 3 이하일때 자동차는 이동하지 않는다.")
    void moveCarStop() {
        int randomValue =

                car.moveCar(carStopNumberGenerator.makeNum());

        assertThat(car.getLocation()).isEqualTo(0);
    }
}
