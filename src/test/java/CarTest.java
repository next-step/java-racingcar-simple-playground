import domain.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void 숫자가_4이상이면_전진한다() {
        Car car = new Car("car1", 0);
        car.move(4);
        assertEquals(1, car.carPosition);
    }

    @Test
    void 숫자가_4미만이면_정지한다() {
        Car car = new Car("car1", 0);
        car.move(3);
        assertEquals(0, car.carPosition);
    }
}
