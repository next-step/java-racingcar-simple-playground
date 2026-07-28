import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import domain.RacingCar;
import domain.RacingGame;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("경계값 테스트: 4, 5일 때 전진")
    void moveForward(int value) {
        RacingCar racingCar = new RacingCar("car1", 0);
        racingCar.move(value);
        assertEquals(1, racingCar.getPosition());
    }


    @Test
    @DisplayName("경계값 테스트: 3일 때 정지")
    void moveStop() {
        RacingCar racingCar = new RacingCar("car1", 0);
        racingCar.move(3);
        assertEquals(0, racingCar.getPosition());
    }


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
