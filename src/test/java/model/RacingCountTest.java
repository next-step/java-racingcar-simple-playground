package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCountTest {

    @DisplayName("레이싱 시도 횟수가 0이하이면 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 0, -2})
    @ParameterizedTest
    void validate_racing_try_count(int value) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new RacingCount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 횟수는 0보다 커야 합니다.");
    }
}
