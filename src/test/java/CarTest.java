import domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    void carMoveForward() {
        Car car = new Car("park");
        car.move(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carMoveNothing() {
        Car car = new Car("seungmin");
        car.move(0);

        assertEquals(car.getPosition(), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 5 })
    void isNameLengthOverFive() {
        assertThatThrownBy(() -> {
            Car car = new Car("seungmin");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
