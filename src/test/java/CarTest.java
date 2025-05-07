import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("값이 4 이상일 경우 전진한다")
    void moveForward(int value) {
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("값이 3 이하일 경우 멈춘다")
    void stop(int value) {
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}