import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RacingCarTest {
    @Test
    @DisplayName("고정된 시드값을 사용하여 자동차 전진여부 확인")
    void randomNumberMoveCar() {
        RandomNumber randomNumber = new RandomNumber(20); // 시드 고정
        RacingCar car = new RacingCar("붕붕이", randomNumber);

        boolean result = car.racingCarStatus();
        System.out.println("랜덤값 참 거짓 확인: " + result);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("n개의 자동차 확인")
    void withCar() {
        RandomNumber randomNumber = new RandomNumber(20); // seed20 -> 9
        RacingCar car1 = new RacingCar("빵빵이", randomNumber);
        RacingCar car2 = new RacingCar("방방이", randomNumber);
        RacingCar car3 = new RacingCar("통통이", randomNumber);

        boolean result1 = car1.racingCarStatus();
        assertThat(result1).isTrue();

        boolean result2 = car2.racingCarStatus();
        assertThat(result2).isTrue();

        boolean result3 = car3.racingCarStatus();
        assertThat(result3).isTrue();
    }

    @Test
    @DisplayName("n개의 자동차가 레이스에 참여할 수 있다")
    void winningRace() {
        RandomNumber randomNumber = new RandomNumber();
        RacingCar car1 = new RacingCar("빵빵이", randomNumber);
        RacingCar car2 = new RacingCar("방방이", randomNumber);
        RacingCar car3 = new RacingCar("통통이", randomNumber);
    }
}
