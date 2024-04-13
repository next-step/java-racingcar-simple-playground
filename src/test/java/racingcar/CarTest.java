package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

class CarTest {

    @Test
    @DisplayName("자동차는 4이상의 값이 입력되면 전진한다.(position을 1 증가 시킨다.)")
    void moveForward() {
        // given
        Car car = new Car("이름");

        // when
        car.moveForward(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차와 동일한 포지션을 입력하면 true를 반환한다.")
    void isSamePosition() {
        // given
        Car car = new Car("이름");
        car.moveForward(4);
        car.moveForward(4);

        // when
        boolean samePosition = car.isSamePosition(2);

        // then
        assertThat(samePosition).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "asdfga"})
    @DisplayName("자동차의 이름이 없거나, 5글자를 초과하면 예외가 발생합니다.")
    void canNotCreateCar_withInvalidName(String invalidName) {
        // expect
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");
    }
}
