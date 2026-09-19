import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("Car1");
        FixedNumGenerator fixedNumber = new FixedNumGenerator(List.of(3, 4));
        car.moveCar(fixedNumber);
        assertTrue(car.isSamePosition(0));

        car = new Car("Car2");
        car.moveCar(fixedNumber);
        assertTrue(car.isSamePosition(1));
    }

    @Test
    void getLargerPosition() {
        Car car = new Car("Car1");
        assertEquals(1, car.getLargerPosition(1));
    }
    
    @Test
    void isSamePosition() {
        Car car = new Car("Car1");
        assertTrue(car.isSamePosition(0));
    }
}
