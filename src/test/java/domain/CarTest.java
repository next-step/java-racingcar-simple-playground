package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("0-9 사이의 random 값이 4이상이면 전진한다")
    public void moveCar_forward_test() {
        Car car = new Car("car0");

        car.moveCar(5);

        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("0-9 사이의 random 값이 4이하면 멈춘다")
    public void moveCar_stop_test() {
        Car car = new Car("car0");

        car.moveCar(3);

        assertEquals(0, car.getPosition());
    }
}
