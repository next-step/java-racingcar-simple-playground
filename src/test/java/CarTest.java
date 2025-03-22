import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void testCarName() {
        Car car = new Car("TestCar", new MovableNumberGenerator());
        assertThat(car.getName()).isEqualTo("TestCar");
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

    @Test
    void testCarHasSamePosition() {
        Car car = new Car("TestCar", new MovableNumberGenerator());
        car.move();
        assertThat(car.hasSamePosition(1)).isEqualTo(true);
    }

    @Test
    void testCarIsNotInPosition() {
        Car car = new Car("TestCar", new MovableNumberGenerator());
        car.move();
        assertThat(car.hasSamePosition(0)).isEqualTo(false);
    }

}
