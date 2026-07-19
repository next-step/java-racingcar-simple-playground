package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("우승자가 한 대인 경기")
    void findSingleWinner() {
        Car car1 = new Car("hyun");
        Car car2 = new Car("Kia");

        car1.move(5); // 4 이상 이므로 +1
        car2.move(3); // 3 이하 이므로 stop

        RacingGame game = new RacingGame(List.of(car1, car2), new FixedNumberGenerator(0));

        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 두 대 이상인 경기")
    void findMultiWinner() {
        Car car1 = new Car("hyun");
        Car car2 = new Car("Kia");
        Car car3 = new Car("Tesla");

        car1.move(5);
        car2.move(3);
        car3.move(6);

        RacingGame game = new RacingGame(List.of(car1, car2, car3), new FixedNumberGenerator(0));

        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car1, car3);
    }

    @Test
    @DisplayName("주어진 횟수 이후 우승한 차 구하는 경기")
    void findMultiCountRaceWinner() {
        Car car1 = new Car("hyun");
        Car car2 = new Car("Kia");
        Car car3 = new Car("Tesla");

        RacingGame game = new RacingGame(List.of(car1, car2, car3), new FixedNumberGenerator(4));

        game.moveCars();

        assertThat(car1.getLocation()).isEqualTo(1);
        assertThat(car2.getLocation()).isEqualTo(1);
        assertThat(car3.getLocation()).isEqualTo(1);
    }

    private static class FixedNumberGenerator implements NumberGenerator {
        private final int number;

        private FixedNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generateNumber() {
            return number;
        }
    }

}
