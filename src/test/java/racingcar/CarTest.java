package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차_전진_테스트")
    void carMovingTest(){
        Car car = new Car("car1");

        car.moveCar(4);
        assertEquals(1, car.getLocation());

        car.moveCar(3);
        assertEquals(1, car.getLocation());
    }
}

