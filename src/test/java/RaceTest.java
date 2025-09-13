import domain.Race;
import domain.Car;
import org.junit.jupiter.api.Test;
import utils.RaceUtils;

import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {
    int testCarCount = 3;
    int testRaceTurn = 5;

    //요구사항
    @Test
    void 레이스의_우승자가_존재한다() {
        Race race = new Race(testCarCount, testRaceTurn);

        List<Car> cars = new utils.CarListGenerator().generateCars(testCarCount);
        List<Car> winners = race.playRace(cars, testRaceTurn);
        assertTrue(!winners.isEmpty());
    }

    @Test
    void 레이스의_우승자는_한명_존재할_수_있다(){
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 3),
                new Car("car3", 2)
        );

        RaceUtils raceUtils = new RaceUtils();
        List<Car> winners = raceUtils.getWinner(cars);

        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0).carName);
    }

    @Test
    void 레이스의_우승자는_두명_이상_존재할_수_있다(){
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 2)
        );

        RaceUtils raceUtils = new RaceUtils();
        List<Car> winners = raceUtils.getWinner(cars);

        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0).carName);
        assertEquals("car3", winners.get(1).carName);
    }

    @Test
    void 전진하지_않은_모두가_공동우승자일_수_있다(){
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 0),
                new Car("car3", 0)
        );
        RaceUtils raceUtils = new RaceUtils();
        List<Car> winners = raceUtils.getWinner(cars);

        assertEquals(3, winners.size());
        assertEquals("car1", winners.get(0).carName);
        assertEquals("car2", winners.get(1).carName);
        assertEquals("car3", winners.get(2).carName);
    }
}
