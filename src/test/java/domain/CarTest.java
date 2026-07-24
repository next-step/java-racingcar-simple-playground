package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 숫자가_4_이상시_자동차_이동() {
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 숫자가_4보다_작을시_자동차_이동하지않음() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isZero();
    }
}