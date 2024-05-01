package domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingCar 객체 테스트")
class RacingCarTest {

    @Test
    @DisplayName("자동차에 이름을 설정해줄 수 있다")
    void settingNameTest() {
        // given
        String name = "경주용자동차";
        // when
        RacingCar racingCar = new RacingCar(name);
        // then
        assertThat(racingCar.getName())
            .isEqualTo(name);
    }

    @Test
    @DisplayName("자동차를 움직일 수 있다")
    void moveTest() {
        // given
        RacingCar racingCar = new RacingCar("경주용자동차");
        int beforeLocation = racingCar.getLocation();
        // when
        racingCar.move();
        // then
        assertTrue(racingCar.getLocation() > beforeLocation);
    }

}
