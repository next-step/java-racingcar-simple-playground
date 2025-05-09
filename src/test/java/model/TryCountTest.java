package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    @DisplayName("시도한 횟수가 최소 횟수보다 작은 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidTryCount() {
        // given
        int count = 0;

        // when & then
        assertThatThrownBy(() -> new TryCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0 이상을 입력해주세요.");
    }
}
