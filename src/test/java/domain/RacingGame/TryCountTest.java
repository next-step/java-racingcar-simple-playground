package domain.RacingGame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Errors;

class TryCountTest {


    @Test
    @DisplayName("입력된 횟수가 음수면 예외가 발생한다.")
    void validateNameTest() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new TryCount(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.INPUT_IS_NOT_NATURAL_NUMBER_ERROR);
    }

}
