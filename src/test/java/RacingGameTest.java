import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class RacingGameTest {
    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외를 던진다")
    void WhenTryCountIsNonPositiveThrowException() {
        List<String> carNames = List.of("A", "B", "C");

        assertSoftly(softly -> {
                assertThrows(IllegalArgumentException.class, () -> {
                    new RacingGame(carNames, 0); // 0일 때
                });
                assertThrows(IllegalArgumentException.class, () -> {
                    new RacingGame(carNames, -1); // 음수일 때
                });
        });
    }

}