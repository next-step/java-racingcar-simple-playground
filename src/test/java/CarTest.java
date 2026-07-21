import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void movesWhenNumberIsGreaterThanThree() {
        Car car = new Car("test");

        car.move(4);

        assertEquals(1, car.getPosition());
    }

    @Test
    void doesNotMoveWhenNumberIsThreeOrLess() {
        Car car = new Car("test");

        car.move(3);

        assertEquals(0, car.getPosition());
    }
}
