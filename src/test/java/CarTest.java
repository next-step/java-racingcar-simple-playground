import domain.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    void 숫자가_4이상이면_전진한다() {
        // given
        Car car = new Car("car1", 0);

        // when
        car.move(4);

        // then
        assertEquals(1, car.getCarPosition());
    }

    @Test
    void 숫자가_4미만이면_정지한다() {
        // given
        Car car = new Car("car1", 0);

        // when
        car.move(3);

        // then
        assertEquals(0, car.getCarPosition());
    }
}