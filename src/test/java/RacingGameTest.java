import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.RandomNumberGenerator;

@DisplayName("자동차 경주 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("숫자가 4 이상이면 전진한다.")
    void moveForward() {
        Car car = new Car("test");
        car.move(5);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 4 미만이면 전진하지 않는다.")
    void doNotMove() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("경주에서 우승한 자동차를 가려낸다. (여러 명일 수 있음)")
    void GetWinners() {
        Car car1 = new Car("일등", 2);
        Car car2 = new Car("이등", 2);
        Car car3 = new Car("삼등", 1);
        Car car4 = new Car("사등", 0);

        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator(), cars);

        List<Car> winners = racingGame.getWinners();

        assertThat(winners).containsExactlyInAnyOrder(car1, car2);
    }

}

