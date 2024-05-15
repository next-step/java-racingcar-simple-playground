package decider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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

    @RepeatedTest(1000)
    @DisplayName("랜덤 값 테스트 1000번 테스트해서 0~9의 범위를 벗어나지 않는지 확인")
    void randomPositionDeciderTest() {
        PositionDecider positionDecider = new RandomPositionDecider();
        final int position = positionDecider.getPosition();
        assertThat(position).isBetween(0, 9);
    }
}
