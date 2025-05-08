import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("값이 4 이상일 경우 전진한다")
    void moveForward(int value) {
        Car car = new Car("car");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("값이 3 이하일 경우 멈춘다")
    void stop(int value) {
        Car car = new Car("car");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 6글자 이상인 경우 예외가 발생한다")
    void validateNameFail() {
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}