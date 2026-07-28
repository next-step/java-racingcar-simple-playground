package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 숫자가_4_이상이면_자동차가_이동한다() {
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 숫자가_4보다_작으면_자동차가_이동하지_않는다() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isZero();
    }
}