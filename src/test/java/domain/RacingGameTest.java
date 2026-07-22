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


        RacingGame game = new RacingGame(List.of(car1, car2), new SequentialNumberGenerator(4, 3));
        game.moveCars();
        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car1);
    }

    @Test
    @DisplayName("우승자가 두 대 이상인 경기")
    void findMultiWinner() {
        Car car1 = new Car("hyun");
        Car car2 = new Car("Kia");
        Car car3 = new Car("Tesla");

        RacingGame game = new RacingGame(List.of(car1, car2, car3), new SequentialNumberGenerator(4, 2, 6));
        game.moveCars();
        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car1, car3);
    }

    @Test
    @DisplayName("여러 라운드 실행 후 자동차 위치 확인")
    void findMultiCountRaceWinner() {
        Car car1 = new Car("hyun");
        Car car2 = new Car("Kia");
        Car car3 = new Car("Tesla");

        RacingGame game = new RacingGame(List.of(car1, car2, car3), new FixedNumberGenerator(4));

        game.moveCars();
        game.moveCars();

        assertThat(car1.getLocation()).isEqualTo(2);
        assertThat(car2.getLocation()).isEqualTo(2);
        assertThat(car3.getLocation()).isEqualTo(2);
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

    private static class SequentialNumberGenerator implements NumberGenerator {
        private final int[] numbers;
        private int index = 0;
        private SequentialNumberGenerator(int... numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generateNumber() {
            return numbers[index++];
        }
    }
}
