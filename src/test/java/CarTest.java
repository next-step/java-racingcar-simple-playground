import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Car 테스트")
public class CarTest {

    @Test
    @DisplayName("숫자가 4 이상이면 이동")
    void moveIf4OrMore() {

        // 준비
        Car car = new Car("seoin");

        // 실행
        car.decide(4);

        // 검증
        assertEquals(1, car.getLocation());

    }

    @Test
    @DisplayName("숫자가 4 미만이면 이동 X")
    void notMoveIfLessThan4(){

        // 준비
        Car car = new Car("seoin");

        // 실행
        car.decide(1);

        // 검증
        assertEquals(0, car.getLocation());
    }
}
