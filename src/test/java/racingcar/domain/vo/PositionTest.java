package racingcar.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("기본 생성자 호출 시 위치는 0이어야 한다")
    void defaultConstructorShouldInitializeToZero() {
        Position position = new Position();

        assertThat(position.value()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100})
    @DisplayName("음수로 생성 시 예외가 발생해야 한다")
    void constructorWithNegativeValueShouldThrowException(int negativeValue) {
        assertThatThrownBy(() -> new Position(negativeValue))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_POSITION_NEGATIVE.getDescription());
    }

    @Test
    @DisplayName("forward 호출 시 값이 1 증가한 새로운 Position 객체를 반환해야 한다")
    void forwardShouldReturnNewPositionWithIncrementedValue() {
        Position position = new Position(5);

        Position newPosition = position.forward();

        assertThat(newPosition).isNotSameAs(position); // 새로운 객체인지 확인
        assertThat(newPosition.value()).isEqualTo(6); // 값이 1 증가했는지 확인
        assertThat(position.value()).isEqualTo(5); // 원본 객체는 변경되지 않았는지 확인
    }

    @Test
    @DisplayName("최대값에 가까운 위치에서도 forward가 정상 동작해야 한다")
    void forwardShouldWorkWithLargeValues() {
        Position position = new Position(Integer.MAX_VALUE - 1);

        Position newPosition = position.forward();

        assertThat(newPosition.value()).isEqualTo(Integer.MAX_VALUE);
    }
}