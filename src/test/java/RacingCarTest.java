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
}
