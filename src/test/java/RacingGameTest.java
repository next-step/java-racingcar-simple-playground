import domain.Car;
import domain.FixedNumberGenerator;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("입력한 이름 수만큼 자동차가 생성되는지 테스트")
    void newRacingGameTest() {
        List<String> carNames = List.of(
                "AAA", "BBB", "CCC"
        );
        int expectedCarCount = 3;

        RacingGame game = new RacingGame(carNames, 1);

        assertThat(game.getCars()).hasSize(expectedCarCount);
    }

    @Test
    @DisplayName("모든 차가 1칸씩 전진하는지 테스트")
    void allCarsMoveTest() {
        List<String> carNames = List.of(
                "AAA", "BBB", "CCC"
        );
        int expectedPosition = 1;

        RacingGame game = new RacingGame(carNames, 1, new FixedNumberGenerator(9));
        game.playRound();

        assertThat(game.getCars())
                .extracting(Car::getPosition)
                .containsOnly(expectedPosition);
    }

    @Test
    @DisplayName("단독 우승 테스트")
    void singleWinnerTest() {
        List<Car> cars = List.of(
                new Car("AAA", 7),
                new Car("BBB", 9),
                new Car("CCC", 3)
        );
        Car expectedWinnerCar = cars.get(1);

        RacingGame game = new RacingGame(cars, new FixedNumberGenerator(9));
        List<Car> actualWinners = game.getWinners();

        assertThat(actualWinners)
                .extracting(Car::getName)
                .containsExactly(expectedWinnerCar.getName());
    }

    @Test
    @DisplayName("공동 우승 테스트")
    void coWinnersTest() {
        List<Car> cars = List.of(
                new Car("AAA", 7),
                new Car("BBB", 9),
                new Car("CCC", 9)
        );
        Car expectedWinnerCar1 = cars.get(1);
        Car expectedWinnerCar2 = cars.get(2);

        RacingGame game = new RacingGame(cars, new FixedNumberGenerator(9));
        List<Car> actualWinners = game.getWinners();

        assertThat(actualWinners)
                .extracting(Car::getName)
                .containsExactly(expectedWinnerCar1.getName(), expectedWinnerCar2.getName());
    }
}
