import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("Car1");
        car.moveCar(3);
        assertEquals(0, car.getPos());

        car = new Car("Car2");
        car.moveCar(4);
        assertEquals(1, car.getPos());
    }
}