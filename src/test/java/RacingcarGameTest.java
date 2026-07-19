import domain.Car;
import domain.NumberGenerator;
import domain.RacingcarGame;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarGameTest {

    class TestNumberGenerator implements NumberGenerator {
        private final int number;

        public TestNumberGenerator(int number) { this.number = number; }

        @Override
        public int getNumber(){
            return number;
        }
    }
    /*
    * 우승 자동차 구하기 로직 테스트
    * */
    @Test
    void 공동_우승자가_없을_때() {
        // Given
        String[] names = {"car1", "car2", "car3"};
        RacingcarGame testGame = new RacingcarGame(names, new TestNumberGenerator(7));

        List<Car> cars = testGame.getCarList();
        cars.get(2).move();

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(cars.get(2), winnerCars.get(0));
        assertEquals(1, winnerCars.size());
    }
    @Test
    void 공동_우승자가_있을_때() {
        // Given
        String[] names = {"car1", "car2", "car3"};
        RacingcarGame testGame = new RacingcarGame(names, new TestNumberGenerator(7));

        List<Car> cars = testGame.getCarList();
        cars.get(1).move();
        cars.get(2).move();

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(cars.get(1), winnerCars.get(0));
        assertEquals(cars.get(2), winnerCars.get(1));
        assertEquals(2, winnerCars.size());
    }
}
