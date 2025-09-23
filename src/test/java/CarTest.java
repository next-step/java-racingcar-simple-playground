import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Test
    void 자동차_이름_설정() {
        String carName = "TestCar";

        Car car = new Car(carName);

        assertEquals(carName, car.getCarName());
    }

    @Test
    void moveForward_호출시_위치_증가() {
        Car car = new Car("TestCar");

        car.moveForward();

        assertEquals(1, car.getPosition());
    }

}
