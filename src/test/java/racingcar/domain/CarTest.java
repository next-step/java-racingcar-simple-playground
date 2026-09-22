package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CarTest {
    @DisplayName("숫자가 4 이상이면 전진한다")
    @Test
    void MoreThanFour() {
        Car myCar = new Car("자동차");

        myCar.move(4);
        assertThat(myCar.getPosition()).isEqualTo(1);

    }

    @DisplayName("숫자가 3 이하이면 멈춘다")
    @Test
    void LessThanFour() {
        Car myCar = new Car("자동차");

        myCar.move(3);
        assertThat(myCar.getPosition()).isEqualTo(0);
    }
}


