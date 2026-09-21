package domainTest;

import domain.TryCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TryCountTest {
    @Test
    @DisplayName("문자열이 숫자가 아니면 예외가 발생한다.")
    void ErrorWhenInputIsNotNumeric() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TryCount("%"));
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("null이 입력되면 예외가 발생한다.")
    void errorWhenInputIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TryCount(null));
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("빈 문자열이 입력되면 예외가 발생한다.")
    void errorWhenInputIsEmpty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TryCount(""));
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("공백이 입력되면 예외가 발생한다.")
    void errorWhenInputIsBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TryCount(" "));
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("0이면 예외가 발생한다.")
    void errorWhenValueIsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TryCount("0"));
        assertEquals("시도 횟수는 0보다 커야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("음수이면 예외가 발생한다.")
    void errorWhenValueIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TryCount("-1"));
        assertEquals("시도 횟수는 0보다 커야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("1이면 예외가 발생하지 않는다.")
    void safeWhenValueIsOne() {
        TryCount tryCount = new TryCount("1");
        assertEquals(1, tryCount.getValue());
    }
}
