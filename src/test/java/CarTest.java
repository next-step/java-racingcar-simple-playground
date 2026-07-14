import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 확인 테스트")
    void CarNameTest() {
        String carName = "자동차";

        Car car = new Car(carName);
        String actual = car.getName();

        assertThat(actual).isEqualTo(carName);
    }

    @Test
    @DisplayName("4이상일 때 자동차가 움직이는지 테스트")
    void CarMoveTest() {
        String carName = "자동차";
        int random = 4;
        int expected = 1;

        Car car = new Car(carName);
        car.move(random);
        int actual = car.getPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3이하일 때 자동차가 안 움직이는지 테스트")
    void CarNotMoveTest() {
        String carName = "자동차";
        int random = 3;
        int expected = 0;

        Car car = new Car(carName);
        car.move(random);
        int actual = car.getPosition();

        assertThat(actual).isEqualTo(expected);
    }
}
