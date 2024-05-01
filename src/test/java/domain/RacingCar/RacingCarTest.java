package domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RacingCar 객체 테스트")
class RacingCarTest {
    
    static RacingCar racingCar = new RacingCar("테스트용 자동차");

    @Test
    @DisplayName("자동차에 이름을 설정해줄 수 있다")
    void settingNameTest() {
        // given
        String name = "경주용자동차";
        // when
        RacingCar createdRacingCar = new RacingCar(name);
        // then
        assertThat(createdRacingCar.getName())
            .isEqualTo(name);
    }

    @ParameterizedTest(name = "값 {0}이 들어가면 자동차는 움직인다")
    @DisplayName("4 이상의 값이 들어가면 자동차는 움직인다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int randomNumber) {
        // given
        int beforeLocation = racingCar.getLocation();
        // when
        racingCar.race(randomNumber);
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
        racingCar.race(randomNumber);
        // then
        assertThat(racingCar.getLocation()).isEqualTo(beforeLocation);
    }

}
