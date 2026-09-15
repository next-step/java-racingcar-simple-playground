import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}
