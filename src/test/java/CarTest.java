
import domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final int MOVE_FORWARD = 4;
    private static final int NOT_MOVE = 3;

    @Test
    void testCarName() {
        Car car = new Car("KIA", new MovableNumberGenerator());

        assertThat(car.getName()).isEqualTo("KIA");
    }

    @Test
    void testCarMove() {

        Car car = new Car("TestCar", new MovableNumberGenerator());
        car.move();
    }

    @Test
    void testCarNotMove() {
        Car car = new Car("TestCar", new NotMovableNumberGenerator());
        car.move();
    }
}
