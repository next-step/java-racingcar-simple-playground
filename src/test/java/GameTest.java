import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("negative - 라운드가 0 이하일 경우 예외 발생")
    void roundException() {
        List<String> carNames = List.of("차1", "차2", "차3");
        assertThrows(IllegalArgumentException.class, () -> new Game(carNames, 0));
        assertThrows(IllegalArgumentException.class, () -> new Game(carNames, -1));
    }
}
