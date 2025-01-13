import model.Car;
import model.CarRaceGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceGameTest {
    @Test
    @DisplayName("주어진 자동차를 이용해 경주를 진행할 경우 올바르게 이동 거리가 반영된 자동차 인스턴스 목록을 반환해야 한다.")
    void should_GetCarList_AfterRounds() {
        List<Car> cars = createTestCars(
                Arrays.asList(Arrays.asList(0, 2), Arrays.asList(8, 3), Arrays.asList(4, 5)), Arrays.asList("Alice", "Bob", "Carl"));

        CarRaceGame carRaceGame = new CarRaceGame(cars);

        List<Car> carsAfterFirstRound = carRaceGame.playSingleRoundAndGetCars();
        assertThat(carsAfterFirstRound.get(0).getDistance()).isEqualTo(0);
        assertThat(carsAfterFirstRound.get(1).getDistance()).isEqualTo(1);
        assertThat(carsAfterFirstRound.get(2).getDistance()).isEqualTo(1);

        List<Car> carsAfterSecondRound = carRaceGame.playSingleRoundAndGetCars();
        assertThat(carsAfterFirstRound.get(0).getDistance()).isEqualTo(0);
        assertThat(carsAfterFirstRound.get(1).getDistance()).isEqualTo(1);
        assertThat(carsAfterFirstRound.get(2).getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 자동차를 이용해 경주를 진행한 이후 우승자 목록을 받아올 때, 우승자가 하나일 경우 그 우승한 자동차 이름을 반환해야 한다.")
    void should_ReturnSingleWinningCarName_WhenCalledWinningListAfterRounds() {
        List<Car> cars = createTestCars(
                Arrays.asList(Arrays.asList(0, 2, 9), Arrays.asList(8, 7, 4), Arrays.asList(4, 3, 4)), Arrays.asList("Alice", "Bob", "Carl"));

        CarRaceGame carRaceGame = new CarRaceGame(cars);

        for (int i = 1; i <= 3; i++) {
            carRaceGame.playSingleRoundAndGetCars();
        }

        List<String> winningCarNames = carRaceGame.getWinners();

        assertThat(winningCarNames).isEqualTo(List.of("Bob"));
    }

    @Test
    @DisplayName("주어진 자동차를 이용해 경주를 진행한 이후 우승자 목록을 받아올 때, 우승자가 하나일 경우 그 우승한 자동차 이름을 반환해야 한다.")
    void should_ReturnWinningCarNames_WhenCalledWinningListAfterRounds() {
        List<Car> cars = createTestCars(
                Arrays.asList(Arrays.asList(1, 5, 8), Arrays.asList(0, 9, 3), Arrays.asList(2, 6, 7)), Arrays.asList("Alice", "Bob", "Carl"));

        CarRaceGame carRaceGame = new CarRaceGame(cars);

        for (int i = 1; i <= 3; i++) {
            carRaceGame.playSingleRoundAndGetCars();
        }

        List<String> winningCarNames = carRaceGame.getWinners();

        assertThat(winningCarNames).isEqualTo(Arrays.asList("Alice", "Carl"));
    }

    private List<Car> createTestCars(List<List<Integer>> randomValues, List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i), new TestRandomNumberGenerator(randomValues.get(i))));
        }

        return cars;
    }
}
