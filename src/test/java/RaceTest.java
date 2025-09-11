import domain.Race;
import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {
    int testCarCount = 3;
    int testRaceTurn = 5;

    @Test
    void 레이스의_우승자가_존재한다() {
        Race race = new Race(testCarCount, testRaceTurn);

        List<Car> cars = new utils.CarListGenerator().generateCars(testCarCount);
        List<Car> winners = race.playRace(cars, testRaceTurn);
        assertTrue(!winners.isEmpty());
    }
}
