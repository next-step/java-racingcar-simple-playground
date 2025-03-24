package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("입력받은 자동차 이름에 맞춰 참가 자동차 목록이 생성되어야 한다.")
    void create_cars_test() {
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        Cars cars = new Cars(carNames);

        assertEquals(3, cars.getCars().size());
        assertEquals("Car1", cars.getCars().get(0).getName());
        assertEquals("Car2", cars.getCars().get(1).getName());
        assertEquals("Car3", cars.getCars().get(2).getName());
    }

    @Test
    @DisplayName("모든 자동차가 움직인 경우, 우승자 목록이 비어 있지 않고 제대로 반환되어야 한다.")
    void testGetWinners() {
        List<String> carNames = List.of("Car1", "Car2");
        Cars cars = new Cars(carNames);

        MovingStrategy movingStrategy = () -> true;
        cars.move(movingStrategy);

        List<Car> winners = Cars.getWinners();
        assertNotNull(winners);
        assertFalse(winners.isEmpty());
    }
}