import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final int MOVE_FORWARD = 4;
    private static final int NOT_MOVE = 3;

    @Test
    void testCarName() {
        Car car = new Car("KIA");
        assertThat(car.getName()).isEqualTo("KIA");
    }

    @Test
    void testCarMove() {
        Car car = new Car("TestCar");
        car.move(MOVE_FORWARD);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void testCarNotMove() {
        Car car = new Car("TestCar");
        car.move(NOT_MOVE - 1);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
