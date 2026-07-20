package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차_전진_테스트")
    void carMovingTest(){
        Car car = new Car("car1");

        car.moveCar();
        car.getLocation();
    }
}

