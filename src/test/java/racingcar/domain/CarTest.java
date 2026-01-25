package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.exception.InputErrorCode;
import racingcar.exception.InvalidInputException;

class CarTest {

    @DisplayName("자동차는 정해진 거리만큼 전진할 수 있다.")
    @Test
    void moveForward() {
        // given
        Car car = new Car("test");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 이름 글자 수가 Null 이거나 비어있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    void throwsExceptionWhenNameIsNullOrBlank(String name) {
        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(InputErrorCode.CAR_NAME_BLANK.message());
    }

    @DisplayName("자동차 이름 글자 수가 5자가 넘으면 예외를 발생시킨다.")
    @Test
    void throwsExceptionWhenNameIsTooLong() {
        // given
        String name = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(InputErrorCode.CAR_NAME_TOO_LONG.message());
    }
}