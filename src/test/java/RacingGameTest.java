import domain.RacingCar;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    @Test
    @DisplayName("우승자 비교하기")
    void whoIsWinner() {
        RacingGame racingGame = new RacingGame();

        racingGame.cars.add(new RacingCar("car1", 3));
        racingGame.cars.add(new RacingCar("car2", 5));
        racingGame.cars.add(new RacingCar("car3", 2));
        racingGame.cars.add(new RacingCar("car4", 5));
        racingGame.cars.add(new RacingCar("car5", 1));

        List<String> expected = List.of("car2", "car4");
        List<String> actual = racingGame.winner();

        assertEquals(expected, actual);
    }
}
