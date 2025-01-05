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
        Car aliceCar = new Car("Alice", new TestRandomNumberGenerator((Arrays.asList(0, 2))));
        Car bobCar = new Car("Bob", new TestRandomNumberGenerator((Arrays.asList(8, 3))));
        Car carlCar = new Car("Carl", new TestRandomNumberGenerator((Arrays.asList(4, 5))));
        List<Car> cars = new ArrayList<>(Arrays.asList(aliceCar, bobCar, carlCar));

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
        Car aliceCar = new Car("Alice", new TestRandomNumberGenerator((Arrays.asList(0, 2, 9))));
        Car bobCar = new Car("Bob", new TestRandomNumberGenerator((Arrays.asList(8, 7, 4))));
        Car carlCar = new Car("Carl", new TestRandomNumberGenerator((Arrays.asList(4, 3, 4))));
        List<Car> cars = new ArrayList<>(Arrays.asList(aliceCar, bobCar, carlCar));

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
        Car aliceCar = new Car("Alice", new TestRandomNumberGenerator((Arrays.asList(1, 5, 8))));
        Car bobCar = new Car("Bob", new TestRandomNumberGenerator((Arrays.asList(0, 9, 3))));
        Car carlCar = new Car("Carl", new TestRandomNumberGenerator((Arrays.asList(2, 6, 7))));
        List<Car> cars = new ArrayList<>(Arrays.asList(aliceCar, bobCar, carlCar));

        CarRaceGame carRaceGame = new CarRaceGame(cars);

        for (int i = 1; i <= 3; i++) {
            carRaceGame.playSingleRoundAndGetCars();
        }

        List<String> winningCarNames = carRaceGame.getWinners();

        assertThat(winningCarNames).isEqualTo(Arrays.asList("Alice", "Carl"));
    }
}
