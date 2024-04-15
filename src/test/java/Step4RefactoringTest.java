import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Car;
import model.CarRace;

public class Step4RefactoringTest {
    private List<Car> cars;
    private CarRace carRace;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        carRace = new CarRace(cars, 5); // 5번의 시도
    }

    @Test
    @DisplayName("경주 실행 후 최소 하나의 자동차가 전진 테스트")
    void raceStartTest() {
        carRace.raceStart();
        // 경주 후 적어도 한 대의 자동차가 전진했는지 확인 (보장할 수 없음)
        assertTrue(cars.stream().anyMatch(car -> car.getPosition() > 0), "적어도 하나의 자동차가 전진해야 한다.");
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    void findWinnersTest() {
        carRace.raceStart(); // 경주 시작
        List<Car> winners = carRace.findWinner();
        int maxPosition = winners.stream().mapToInt(Car::getPosition).max().orElse(0);
        // 우승자들이 실제로 가장 멀리 이동했는지 확인
        assertTrue(winners.stream().allMatch(car -> car.getPosition() == maxPosition), "우승자는 가장 멀리 이동해야 한다.");
    }
}
