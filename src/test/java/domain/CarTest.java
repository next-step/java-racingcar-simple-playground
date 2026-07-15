package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진한다")
    void moveWhenRandomNumberIsFourOrMore() {
        Car car = new Car("green");

        car.moveCar(4);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하이면 정지한다")
    void stopWhenRandomNumberIsThreeOrLess() {
        Car car = new Car("green");

        car.moveCar(3);

        assertThat(car.getLocation()).isZero();
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
