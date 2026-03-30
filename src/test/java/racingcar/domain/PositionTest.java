package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@SuppressWarnings("NonAsciiCharacters")
public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 8, 20})
    void 앞으로_전진하면_위치가_증가한다(int steps) {
        Position position = new Position();

        for (int i = 0; i < steps; i++) {
            position.forward();
        }

        assertThat(position.get()).isEqualTo(steps);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -5, 0, 3, 7})
    void 초기_위치에_상대적으로_움직인다(int initialPosition) {
        int steps = 5;
        Position position = new Position(initialPosition);

        for (int i = 0; i < steps; i++) {
            position.forward();
        }

        assertThat(position.get()).isEqualTo(initialPosition + steps);
    }

    @Test
    void 오버플로우가_난다면_오류를_발생시킨다() {
        Position position = new Position(Integer.MAX_VALUE);
        assertThatThrownBy(position::forward)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("현재 위치에서 전진할 수 없습니다.");
    }
}
