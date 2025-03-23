package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarMoveTest {

    @Test
    @DisplayName("0-9 사이의 random 값이 4이상이면 전진한다.")
    void forward_test() {
        Car car = new Car("testCar");
        MovingStrategy alwaysMoveForward = () -> true;

        car.move(alwaysMoveForward);

        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("0-9 사이의 random 값이 4이하면 멈춘다")
    void stop_test() {
        Car car = new Car("testCar");
        MovingStrategy neverMove = () -> false;

        car.move(neverMove);

        assertEquals(0, car.getPosition());
    }
}
