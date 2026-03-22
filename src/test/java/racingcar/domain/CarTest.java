package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @DisplayName("4 이상이면 전진한다")
    @Test
    void move() {
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("3 이하이면 멈춘다")
    @Test
    void stop() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차 이름이 5자 초과되면 예외처리된다")
    @Test
    void validName() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
