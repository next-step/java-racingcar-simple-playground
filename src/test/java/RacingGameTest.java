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

    private static class FixedNumberCar extends Car { // 테스트를 위해 예측 가능한 자동차의 움직임을 구현
        private final int number;

        FixedNumberCar(String name, int number) {
            super(name);
            this.number = number;
        }

        @Override
        void move() {
            moveCar(number);
        }
    }

    @Test
    @DisplayName("주어진 횟수 이후 우승한 차 구하는 경기")
    void findMultiCountRaceWinner() {
        Car car1 = new FixedNumberCar("Hyundai", 3);
        Car car2 = new FixedNumberCar("Kia", 4);
        Car car3 = new FixedNumberCar("Tesla", 6);

        RacingGame game = new RacingGame(List.of(car1, car2, car3));

        game.moveCars(3);

        List<Car> winners = game.findWinners();

        assertThat(winners).containsExactly(car2, car3);
    }
}
