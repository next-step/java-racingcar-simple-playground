import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void movesWhenNumberIsFourOrMore() {
        Car car = new Car("pobi");
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}