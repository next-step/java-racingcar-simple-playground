package car.controller;

import car.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameControllerTest {

    @Test
    @DisplayName("랜덤값이 4 이상이면 전진 테스트")
    void moveForwardWithRandomNumber() {
        // given
        Car car = new Car("carA");

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    @DisplayName("랜덤값이 3 이하면 제자리 테스트")
    void stayInPlaceWithRandomNumber() {
        // given
        Car car = new Car("carA");

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    @DisplayName("우승자 확인 테스트")
    void winner() {
        // given
        RacingCars racingCars = new RacingCars(List.of("CarA", "CarB", "CarC"));

        Car carA = racingCars.getCars().get(0);
        Car carB = racingCars.getCars().get(1);
        Car carC = racingCars.getCars().get(2);

        // when

        carA.move(5);
        carB.move(3);
        carC.move(2);
        Winner winner = new Winner();
        winner.findWinner(racingCars);


        // then
        assertThat(racingCars.getWinner()).isEqualTo("CarA");
    }

    @Test
    @DisplayName("쉼표로 구분하여 차 생성하는 테스트")
    void createCars() {
        // given
        String carNames = "CarA,CarB,CarC";
        CarName carName = new CarName();
        carName.setCarName(carNames);
        RacingCars racingCars = new RacingCars(carName.getCarNames());

        // then
        assertThat(racingCars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력 테스트")
    void validCarName() {
        // given
        String input = "CarA,CarB,CarC";

        // when
        CarName carName = new CarName();
        carName.setCarName(input);

        // then
        assertEquals(Arrays.asList("CarA", "CarB", "CarC"), carName.getCarNames());
    }
    @Test
    @DisplayName("중복된 이름이 있으면 예외 발생")
    void duplicateCarName() {

        // given
        CarName carName = new CarName();
        String inputCarNames = "CarA,CarB,CarA";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carName.setCarName(inputCarNames));
        assertEquals("중복된 이름이 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("차 이름이 5글자가 넘어가면 예외 발생")
    void carNameLengthOverFive() {

        // given
        CarName carName = new CarName();
        String inputCarNames = "CarA,CarB,CarCarC";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carName.setCarName(inputCarNames));
        assertEquals("5글자 이하로 입력하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 회수에 숫자 외의 값이 들어오면 예외 발생")
    void gameNumberInvalid() {
        // given
        String invalidInput = "abc";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new GameNumber(invalidInput));
        assertEquals("숫자만 입력하세요.", exception.getMessage());
    }
    @Test
    @DisplayName("시도 회수에 숫자만 허용")
    void gameNumberValid() {
        // given
        String validInput = "10";

        // when, then
        assertDoesNotThrow(() -> new GameNumber(validInput));
    }
}