import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("Car1");
        FixedNumGenerator fixedNumber3 = new FixedNumGenerator(3);
        car.moveCar(fixedNumber3);
        assertTrue(car.isSamePosition(0));

        car = new Car("Car2");
        FixedNumGenerator fixedNumber4 = new FixedNumGenerator(4);
        car.moveCar(fixedNumber4);
        assertTrue(car.isSamePosition(1));
    }
}
