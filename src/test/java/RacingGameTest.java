import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

public class RacingGameTest {
    @Test
    @DisplayName("한 라운드에 자동차 여러대가 각자 이동한다")
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
    @DisplayName("가장 멀리 이동한 자동차가 한 대이면 우승자도 한 명이다")
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
    @DisplayName("가장 멀리 이동한 자동차가 여러 대이면 우승자도 여러 명이다")
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

    @Test
    @DisplayName("자동차 수와 이동 값의 개수가 다르면 예외가 발생한다")
    void throwExceptionWhenCarAndNumberCountsDiffer() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

        List<Integer> numbers = Arrays.asList(6, 2);

        RacingGame racingGame = new RacingGame(cars);

        assertThrows(
            IllegalArgumentException.class,
            () -> racingGame.moveCars(numbers)
        ); 
    }

    @Test
    @DisplayName("모든 자동차의 위치가 같으면 모두 공동 우승자이다")
    void findsAllCarsAsWinnersWhenPositionsAreEqual() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

        RacingGame racingGame = new RacingGame(cars);

        List<Car> winners = racingGame.findWinners();

        assertEquals(3, winners.size());
    }
}
