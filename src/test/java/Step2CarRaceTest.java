import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Car;
import model.CarRace;

public class Step2CarRaceTest {
    private List<Car> cars;
    private CarRace carRace;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        carRace = new CarRace(cars, 5);
    }

    @Test
    @DisplayName("경주 시작 테스트")
    void raceStartTest() {
        carRace.raceStart();
        assertTrue(cars.stream().mapToInt(Car::getPosition).sum() > 0, "경주 후 적어도 하나 이상의 자동차가 전진해야 한다.");
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    void findWinnersTest() {
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(1).move(4);
        cars.get(2).move(4);

        List<Car> winners = carRace.findWinner();
        assertEquals(1, winners.size(), "정확히 하나의 우승자가 있어야 한다.");
        assertEquals("Car2", winners.get(0).getName(), "Car2가 우승자여야 한다.");
    }
}
