package domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.RandomNumberProvider;

class GameTest {

    @Test
    @DisplayName("negative - 라운드가 0 이하일 경우 예외 발생")
    void tryCountIsPositive() {
        String carNames = "차1,차2,차3";
        assertThrows(IllegalArgumentException.class, () -> new Game(carNames, 0, new RandomNumberProvider()));
        assertThrows(IllegalArgumentException.class, () -> new Game(carNames, -1, new RandomNumberProvider()));
    }
}
