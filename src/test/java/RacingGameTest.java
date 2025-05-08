import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("우승자가 한 명 이상일 경우 모두 출력한다")
    void getWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        List<Car> cars = List.of(car1, car2);
        RacingGame racingGame = new RacingGame(cars);
        car1.move(4);
        car2.move(4);

        assertThat(racingGame.getWinners()).containsExactlyInAnyOrder(car1, car2);
    }
}