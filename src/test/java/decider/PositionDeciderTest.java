package decider;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionDeciderTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("1~9 벗어난 범위는 Runtime 예외 발생")
    void exceptionNotAllowedRange(int value) {
        PositionDecider positionDecider = new StaticPositionDecider(value);
        assertThatThrownBy(positionDecider::getPosition)
            .isInstanceOf(RuntimeException.class);
    }
}
