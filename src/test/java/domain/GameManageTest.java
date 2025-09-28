package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameManageTest {

    @Test
    void 한라운드후자동차가이동할수있다() {
        // given
        Cars cars = Cars.createCars(Arrays.asList("car1", "car2"));
        GameManage game = new GameManage(cars);

        cars.getCars().get(0).moveCar();

        // when
        game.raceOneRound();
        // then
        List<Car> result = cars.getCars();
        assertTrue(result.get(0).getCarPosition() >= 0);
        assertTrue(result.get(1).getCarPosition() >= 0);
    }

    @Test
    void 우승자가한명이다() {
        // given
        Cars cars = Cars.createCars(Arrays.asList("car1", "car2"));
        GameManage game = new GameManage(cars);

        cars.getCars().get(0).moveCar();

        // when
        Winners winners = game.race(0);

        // then
        List<String> result = winners.getWinners();
        assertEquals(1, result.size());
        assertEquals("car1", result.get(0));
    }

    @Test
    void 우승자가두명이다() {
        // given
        Cars cars = Cars.createCars(Arrays.asList("car1", "car2"));
        GameManage game = new GameManage(cars);

        cars.getCars().get(0).moveCar();
        cars.getCars().get(1).moveCar();

        // when
        Winners winners = game.race(0);

        // then
        List<String> result = winners.getWinners();
        assertEquals(2, result.size());
        assertEquals("car1", result.get(0));
        assertEquals("car2", result.get(1));
    }
}
