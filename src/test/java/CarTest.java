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

    @Test
    void 숫자가_매우_큰_경우에_전진한다() {
        // given
        Car car = new Car("car1", 0);

        // when
        car.move(2147483647);

        // then
        assertEquals(1, car.getCarPosition());
    }

    @Test
    void 숫자가_매우_작은_경우에_정지한다() {
        // given
        Car car = new Car("car1", 0);

        // when
        car.move(-2147483647);

        // then
        assertEquals(0, car.getCarPosition());
    }

    @Test
    void 여러_번_전진하면_위치가_누적된다() {
        // given
        Car car = new Car("car", 0);

        // when
        car.move(9);
        car.move(6);
        car.move(4);
        car.move(3);

        // then
        assertEquals(3, car.getCarPosition());
    }
}
