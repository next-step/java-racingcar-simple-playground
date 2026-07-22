import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import domain.RacingCar;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상이면 전진, return 1")
    void moveForward(int value) {
        RacingCar racingCar = new RacingCar();
        assertEquals(1, racingCar.moveReturn(value));
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("3 이하이면 멈춤, return 0")
    void moveStop(int value) {
        RacingCar racingCar = new RacingCar();
        assertEquals(0, racingCar.moveReturn(value));
    }


    @Test
    @DisplayName("우승자 비교하기")
    void whoIsWinner() {
        RacingCar racingCar = new RacingCar();

        racingCar.car.put("car1", 3);
        racingCar.car.put("car2", 5);
        racingCar.car.put("car3", 2);
        racingCar.car.put("car4", 5);
        racingCar.car.put("car5", 1);

        List<String> expected = List.of("car2", "car4");
        List<String> actual = racingCar.winner();

        assertEquals(expected, actual);
    }


}
