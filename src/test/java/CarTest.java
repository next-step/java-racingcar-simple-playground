import domain.Car;
import org.junit.jupiter.api.Test;

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
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void testCarNotMove() {
        Car car = new Car("TestCar", new NotMovableNumberGenerator());
        car.move();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
