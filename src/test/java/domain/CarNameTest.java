package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 빈_이름_생성_불가능() {
        assertThrows(IllegalArgumentException.class,
                () -> new CarName(""));
    }

    @Test
    void 공백으로만_된_이름_생성_불가능() {
        assertThrows(IllegalArgumentException.class,
                () -> new CarName("   "));
    }

    @Test
    void 자동차_이름_5자_초과_불가능() {
        assertThrows(IllegalArgumentException.class,
                () -> new CarName("abcdef"));
    }

    @Test
    void 자동차_이름은_5자까지_가능() {
        assertDoesNotThrow(() -> new CarName("abcde"));
    }
}
