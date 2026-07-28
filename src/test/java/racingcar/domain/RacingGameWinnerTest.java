package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameWinnerTest {
    FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();

    @Test
    @DisplayName("가장 많이 전진한 자동차가 단독 우승자가 된다.")
    void selectSingleWinner() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.moveCar(fixedNumberGenerator.makeNum());
        car2.moveCar(fixedNumberGenerator.makeNum());
        car2.moveCar(fixedNumberGenerator.makeNum());
        car3.moveCar(fixedNumberGenerator.makeNum());

        RacingGame racingGame = new RacingGame(List.of(car1, car2, car3), 5);
        RacingGameWinner winnerSelector = new RacingGameWinner();

        List<Car> winners = winnerSelector.selectWinners(racingGame);

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("Car2");
    }

    @Test
    @DisplayName("최고 위치에 도달한 자동차가 여러 대일 경우 공동 우승자가 된다.")
    void selectMultipleWinners() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        car1.moveCar(fixedNumberGenerator.makeNum());
        car2.moveCar(fixedNumberGenerator.makeNum());

        RacingGame racingGame = new RacingGame(List.of(car1, car2), 5);
        RacingGameWinner winnerSelector = new RacingGameWinner();

        List<Car> winners = winnerSelector.selectWinners(racingGame);

        assertThat(winners).hasSize(2).extracting(Car::getName).containsExactlyInAnyOrder("Car1", "Car2");
    }
}
