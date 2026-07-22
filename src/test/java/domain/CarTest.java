package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("차가 1칸 이동한다")
    void moveCarOneBlock() {
        Car car = new Car("green");

        car.move();

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하면 생성한다")
    void createCarWithNameUnderFiveCharacters() {
        Car car = new Car("hansu");

        assertThat(car.getName()).isEqualTo("hansu");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void throwExceptionWhenNameExceedsFiveCharacters() {
        assertThatThrownBy(() -> new Car("hansung"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
