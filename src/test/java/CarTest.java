import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("Car1", 0);
        FixedNumGenerator fixedNumber = new FixedNumGenerator(List.of(3, 4));
        car.moveCar(fixedNumber);
        assertTrue(car.isSamePosition(0));

        car = new Car("Car2", 0);
        car.moveCar(fixedNumber);
        assertTrue(car.isSamePosition(1));
    }

    @Test
    void getLargerPosition() {
        Car car = new Car("Car1", 0);
        assertEquals(1, car.getLargerPosition(1));
    }

    @Test
    void isSamePosition() {
        Car car = new Car("Car1", 0);
        assertTrue(car.isSamePosition(0));
    }
}
