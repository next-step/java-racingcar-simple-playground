import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class RacingGameTest {
    @Test
    void movesMultipleCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

        RacingGame racingGame = new RacingGame(cars);

        racingGame.moveCars(Arrays.asList(4, 3, 7));

        assertEquals(1, cars.get(0).getPosition());
        assertEquals(0, cars.get(1).getPosition());
        assertEquals(1, cars.get(2).getPosition());
    }

    @Test
    void findWinnerWithMaxPosition() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

        RacingGame racingGame = new RacingGame(cars);

        racingGame.moveCars(Arrays.asList(4, 3, 7));
        racingGame.moveCars(Arrays.asList(5, 2, 2));

        List<Car> winners = racingGame.findWinners();

        assertEquals(1, winners.size());
        assertEquals("test1", winners.get(0).getName());
    }

    @Test
    void findAllWinnersWithMaxPosition() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

        RacingGame racingGame = new RacingGame(cars);

        racingGame.moveCars(Arrays.asList(4, 3, 7));
        racingGame.moveCars(Arrays.asList(5, 2, 5));

        List<Car> winners = racingGame.findWinners();

        assertEquals(2, winners.size());
        assertEquals("test1", winners.get(0).getName());
        assertEquals("test3", winners.get(1).getName());
    }
}
