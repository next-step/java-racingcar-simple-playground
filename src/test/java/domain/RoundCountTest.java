package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RoundCountTest {

    @Test
    void 시도_횟수_0_불가능() {
        assertThrows(IllegalArgumentException.class,
                () -> new RoundCount(0));
    }

    @Test
    void 시도_횟수_음수_불가능() {
        assertThrows(IllegalArgumentException.class,
                () -> new RoundCount(-1));
    }

    @Test
    void 시도_횟수_생성() {
        assertDoesNotThrow(() -> new RoundCount(1));
    }
}
