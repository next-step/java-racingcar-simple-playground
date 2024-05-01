package service;

import static org.junit.jupiter.api.Assertions.*;

import domain.Car.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RacingCarService 테스트")
class RacingCarServiceTest {

    static RacingCarService racingCarService = new RacingCarService();
    static RacingCar racingCar = new RacingCar("테스트용 자동차");

    @ParameterizedTest(name = "값 {0}이 들어가면 자동차는 움직인다")
    @DisplayName("4 이상의 값이 들어가면 자동차는 움직인다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int randomNumber) {
        // given
        int beforeLocation = racingCar.getLocation();
        // when
        racingCarService.race(racingCar, randomNumber);
        // then
        assertTrue(racingCar.getLocation() > beforeLocation);
    }

    @ParameterizedTest(name = "값 {0}이 들어가면 자동차는 움직이지 않는다")
    @DisplayName("4 이상의 값이 들어가면 자동차는 움직이지 않는다")
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int randomNumber) {
        // given
        int beforeLocation = racingCar.getLocation();
        // when
        racingCarService.race(racingCar, randomNumber);
        // then
        assertEquals(racingCar.getLocation(), beforeLocation);
    }

}
