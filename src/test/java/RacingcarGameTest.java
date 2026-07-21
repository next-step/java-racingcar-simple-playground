import domain.Car;
import domain.NumberGenerator;
import domain.RacingcarGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarGameTest {
    static class TestNumberGenerator implements NumberGenerator {
        @Override
        public int getNumber() {
            return 0;
        }
    }

    @Test
    void 공동_우승자가_없는_경우() {
        // Given
        String[] names = {"car1", "car2", "car3"};
        NumberGenerator numberGenerator = new TestNumberGenerator();
        RacingcarGame testGame = new RacingcarGame(names, numberGenerator);

        List<Car> cars = testGame.getCars();
        cars.get(2).move(7);

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(cars.get(2), winnerCars.get(0));
        assertEquals(1, winnerCars.size());
    }
    @Test
    void 공동_우승자가_있는_경우() {
        // Given
        String[] names = {"car1", "car2", "car3"};
        NumberGenerator numberGenerator = new TestNumberGenerator();
        RacingcarGame testGame = new RacingcarGame(names, numberGenerator);

        List<Car> cars = testGame.getCars();
        cars.get(1).move(7);
        cars.get(2).move(7);

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(cars.get(1), winnerCars.get(0));
        assertEquals(cars.get(2), winnerCars.get(1));
        assertEquals(2, winnerCars.size());
    }
    @Test
    void 모든_자동차가_공동_우승자인_경우() {
        // Given
        String[] names = {"car1", "car2", "car3"};
        NumberGenerator numberGenerator = new TestNumberGenerator();
        RacingcarGame testGame = new RacingcarGame(names, numberGenerator);

        List<Car> cars = testGame.getCars();

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(cars.get(0), winnerCars.get(0));
        assertEquals(cars.get(1), winnerCars.get(1));
        assertEquals(cars.get(2), winnerCars.get(2));
        assertEquals(3, winnerCars.size());
    }
}
