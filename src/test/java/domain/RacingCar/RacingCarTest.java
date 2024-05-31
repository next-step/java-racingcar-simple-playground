package domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.Errors;

@DisplayName("RacingCar 객체 테스트")
class RacingCarTest {

    static RacingCar racingCar = new RacingCar("테스트차");

    @Test
    @DisplayName("자동차에 이름을 설정해줄 수 있다")
    void settingNameTest() {
        // given
        String name = "경주용차";
        // when
        RacingCar createdRacingCar = new RacingCar(name);
        // then
        assertThat(createdRacingCar.getName())
            .isEqualTo(name);
    }

    @ParameterizedTest(name = "이름 = {0}은 다섯자리가 넘어 예외가 발생한다.")
    @ValueSource(strings = {"neooooo", "minjuuuu", "경주용자동차"})
    @DisplayName("입력된 이름이 다섯 글자가 넘어가면 예외가 발생한다.")
    void validateNameTest(String inputName) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new RacingCar(inputName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Errors.getLengthOfCarNameError(inputName, 5));
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
