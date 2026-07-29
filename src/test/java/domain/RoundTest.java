package domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("시도 횟수가 0 이하이면 예외가 발생한다")
    void throwsExceptionWhenRoundIsZeroOrNegative(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> Round.from(input)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "100"})
    @DisplayName("시도 횟수가 허용 범위의 경계값이면 정상적으로 생성된다")
    void createsRoundWhenValueIsBoundary(String input) {
        Round round = Round.from(input);

        assertEquals(Integer.parseInt(input), round.getValue());
    }

    @Test
    @DisplayName("시도 횟수가 최대값을 초과하면 예외가 발생한다")
    void throwsExceptionWhenRoundExceedsMaximum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Round.from("101")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.5", "abc", "99999999999999999999"})
    @DisplayName("시도 횟수가 정수로 변환될 수 없으면 예외가 발생한다")
    void throwsExceptionWhenRoundCountIsNotInteger(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> Round.from(input)
        );
    }
}
