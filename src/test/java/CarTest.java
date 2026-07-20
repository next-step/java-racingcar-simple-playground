import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    Car car = new Car("테스트_자동차");

    @Test
    @DisplayName("움직이는 기능이 의도대로 동작하는지 테스트")
    void moveTest() {
        var num = car.setNum();
        if (num <= 3) {
            return;
        }
        car.moveCar();
        int expected = 1;
        int actual = car.position;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("멈추는 기능이 의도대로 동작하는지 테스트")
    void stopTest() {
        var num = car.setNum();
        if (num >= 4) {
            return;
        }
        car.stopCar();
        int expected = 0;
        int actual = car.position;
        assertEquals(expected, actual);
    }
}
