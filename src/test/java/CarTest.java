import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    @DisplayName("4 이상이면 전진")
    void moveTest(){
        Car car = new Car("테스트");
        car.move(4);
        assertEquals(1, car.position);
    }

    @Test
    @DisplayName("3 이하면 정지")
    void stopTest(){
        Car car = new Car("테스트");
        car.move(3);
        assertEquals(0, car.position);
    }
}
