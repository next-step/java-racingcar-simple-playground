package racingCar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.numberGenerator.NumberGenerator;
import racingCar.mock.GeneratorNumber1;
import racingCar.mock.GeneratorNumber4;

@DisplayName("자동차 테스트")
class CarTest {
    NumberGenerator number1Generator = new GeneratorNumber1();
    NumberGenerator number4Generator = new GeneratorNumber4();

    @Test
    @DisplayName("4 이상이면 전진")
    void moveTest() {
        Car car = new Car("테스트", number4Generator);
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("3 이하면 정지")
    void stopTest() {
        Car car = new Car("테스트", number1Generator);
        car.move();
        assertEquals(0, car.getPosition());
    }
}
