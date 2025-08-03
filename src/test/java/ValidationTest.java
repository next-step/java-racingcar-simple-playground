import model.RacingGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "fivenames", ",ad"})
    void carNameExceptionTest(String carNames){

        RacingGame game = new RacingGame(new Random());
        assertThrows(RuntimeException.class,
                () -> game.initializeGame(carNames.split(","), 1)
        );
    }
}
