import domain.Car;
import domain.Race;
import org.junit.jupiter.api.Test;
import utils.RandomDigitGenerator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {
    private static final int testCarCount = 3;
    private static final int testRaceTurn = 5;
    RandomDigitGenerator randomDigitGenerator = new RandomDigitGenerator();

    //요구사항
    @Test
    void 레이스의_우승자가_존재한다() {
        Race race = new Race(testCarCount, testRaceTurn, randomDigitGenerator);

        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 3),
                new Car("car3", 2)
        );
        List<Car> winners = race.playRace(cars, testRaceTurn);
        assertTrue(!winners.isEmpty());
    }

    @Test
    void 레이스의_우승자는_한명_존재할_수_있다() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 3),
                new Car("car3", 2)
        );

        List<Car> winners = new Race(testCarCount, testRaceTurn, randomDigitGenerator).getWinner(cars);

        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0).getCarName());
    }

    @Test
    void 레이스의_우승자는_두명_이상_존재할_수_있다() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 2),
                new Car("car3", 2)
        );

        List<Car> winners = new Race(testCarCount, testRaceTurn, randomDigitGenerator).getWinner(cars);

        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0).getCarName());
        assertEquals("car3", winners.get(1).getCarName());
    }

    @Test
    void 전진하지_않은_모두가_공동우승자일_수_있다() {
        List<Car> cars = Arrays.asList(
                new Car("car1", 0),
                new Car("car2", 0),
                new Car("car3", 0)
        );
        List<Car> winners = new Race(testCarCount, testRaceTurn, randomDigitGenerator).getWinner(cars);

        assertEquals(3, winners.size());
        assertEquals("car1", winners.get(0).getCarName());
        assertEquals("car2", winners.get(1).getCarName());
        assertEquals("car3", winners.get(2).getCarName());
    }
}
