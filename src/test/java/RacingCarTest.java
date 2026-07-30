import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.RacingCar;

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
    @DisplayName("이름이 비었는지 테스트")
    void nameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new RacingCar("", 0));
    }

    @Test
    @DisplayName("위치가 음수인지 테스트")
    void positionNegative() {
        assertThrows(IllegalArgumentException.class, () -> new RacingCar("a", -1));
    }


}
