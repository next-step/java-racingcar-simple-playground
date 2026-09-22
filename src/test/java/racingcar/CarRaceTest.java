package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.domain.Car;
import racingcar.domain.CarRace;
import racingcar.domain.NumberGenerator;

import java.util.List;

public class CarRaceTest {
    @DisplayName("1,2번차 공동우승한다")
    @Test
    void findWinnersTest() {
        Car car1 = new Car("동건");
        Car car2 = new Car("규민");
        Car car3 = new Car("재홍");
        List<Car> cars = List.of(car1, car2, car3);
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(5, 5, 1));
        CarRace carRace = new CarRace(cars, numberGenerator);

        carRace.race(1);
        List<Car> winners = carRace.findWinners();

        assertThat(winners).isEqualTo(List.of(car1, car2));
    }

    @DisplayName("1번차만 승리한다")
    @Test
    void findOnlyOneWinnerTest() {
        Car car1 = new Car("동건");
        Car car2 = new Car("규민");
        Car car3 = new Car("재홍");
        List<Car> cars = List.of(car1, car2, car3);
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(5, 2, 1));
        CarRace carRace = new CarRace(cars, numberGenerator);

        carRace.race(1);
        List<Car> winners = carRace.findWinners();

        assertThat(winners).isEqualTo(List.of(car1));
    }

    @DisplayName("모든차가 승리한다")
    @Test
    void findAllWinnerTest() {
        Car car1 = new Car("동건");
        Car car2 = new Car("규민");
        Car car3 = new Car("재홍");
        List<Car> cars = List.of(car1, car2, car3);
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(5, 2, 1));
        CarRace carRace = new CarRace(cars, ()->4);

        carRace.race(1);
        List<Car> winners = carRace.findWinners();

        assertThat(winners).isEqualTo(List.of(car1,car2,car3));
    }


}
