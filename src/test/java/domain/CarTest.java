package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("숫자가 4 이상이면 전진한다")
    void moveForward() {
        Car car = new Car("car");
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 3 이하면 멈춘다")
    void stop() {
        Car car = new Car("car");
        car.move(2);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 비어있거나 null인 경우 예외가 발생한다")
    void createEmptyName() {
        assertAll(
                () -> assertThatThrownBy(() -> new Car(""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Car(" "))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Car(null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름이 6글자 이상이면 예외가 발생한다")
    void createLongName() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}