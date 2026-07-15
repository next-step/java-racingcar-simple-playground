import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("우승자가 한 대인 경기")
    void findSingleWinner() {
        Car car1 = new Car("Hyundai");
        Car car2 = new Car("Kia");

        car1.moveCar(5); // 4 이상 이므로 +1
        car2.moveCar(3); // 3 이하 이므로 stop

        RacingGame game = new RacingGame(List.of(car1, car2));

        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 두 대 이상인 경기")
    void findMultiWinner() {
        Car car1 = new Car("Hyundai");
        Car car2 = new Car("Kia");
        Car car3 = new Car("Tesla");

        car1.moveCar(5);
        car2.moveCar(3);
        car3.moveCar(6);

        RacingGame game = new RacingGame(List.of(car1, car2, car3));

        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car1, car3);
    }
}
