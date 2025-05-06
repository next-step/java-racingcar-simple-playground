import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RacingCarTest {

    @Test
    @DisplayName("자동차 이름과 전진여부 확인")
    void carStatus() {


        RandomNumber randomNumber = new RandomNumber();
        RacingCar car = new RacingCar("붕붕이", randomNumber);


        String name = car.carName();
        boolean result = car.racingCarStatus();

        if (result) {
            System.out.println("차의 이름은 " + name+ "이고 " + "전진합니다");
        }
        if (!result){
            System.out.println("차의 이름은 " + name+ "이고 " + "멈췄습니다");
        }
        assertThat(result).isTrue();
    }
}
