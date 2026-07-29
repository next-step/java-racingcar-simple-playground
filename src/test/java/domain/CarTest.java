package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void movesWhenNumberIsFourOrMore() {
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void doesNotMoveWhenNumberIsLessThanFour() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isZero();
    }
}