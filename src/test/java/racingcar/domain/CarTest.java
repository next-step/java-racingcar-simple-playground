package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @Test
    @DisplayName("자동차는 4이상의 값이 입력되면 전진한다.")
    void moveForward() {
        // given
        Car car = new Car("이름", 0, () -> 4);

        // when
        Car movedCar = car.moveForward();

        // then
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 4미만의 값이 입력되면 전진하지 않는다.")
    void doesNotMoveForward() {
        // given
        Car car = new Car("이름", 0, () -> 3);

        // when
        Car movedCar = car.moveForward();

        // then
        assertThat(movedCar.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차와 동일한 포지션을 입력하면 true를 반환한다.")
    void isSamePosition() {
        // given
        Car car = new Car("이름", 2, () -> 4);

        // when
        boolean samePosition = car.isSamePosition(2);

        // then
        assertThat(samePosition).isTrue();
    }

    @Test
    @DisplayName("자동차와 동일한 포지션을 입력하면 false를 반환한다.")
    void isNotSamePosition() {
        // given
        Car car = new Car("이름", 2, () -> 4);

        // when
        boolean samePosition = car.isSamePosition(3);

        // then
        assertThat(samePosition).isFalse();
    }

    @ParameterizedTest
    @MethodSource("getInvalidNames")
    @DisplayName("자동차의 이름이 없거나, 5글자를 초과하면 예외가 발생한다.")
    void canNotCreateCar_withInvalidName(String invalidName) {
        // expect
        assertThatThrownBy(() -> new Car(invalidName, 0, () -> 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 반드시 존재해야 하고, 최대 5글자 이하여야 합니다.");
    }

    static Stream<String> getInvalidNames() {
        return Stream.of("", "asdfgh", null);
    }
}
