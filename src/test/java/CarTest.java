import domain.Car;
import domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("움직이는 기능이 의도대로 동작하는지 테스트")
    void moveTest() {
        Car car = new Car("테스트_자동차");
        NumberGenerator numberGenerator = new FixedNumberGenerator(4);
        var num = numberGenerator.generate();
        if (num >= 4) {
            car.moveCar();
        }
        assertEquals(1, car.position);
    }

    @Test
    @DisplayName("멈추는 기능이 의도대로 동작하는지 테스트")
    void stopTest() {
        Car car = new Car("테스트_자동차");
        NumberGenerator numberGenerator = new FixedNumberGenerator(3);
        var num = numberGenerator.generate();
        if (num <= 3) {
            car.stopCar();
        }
        assertEquals(0, car.position);
    }
}
