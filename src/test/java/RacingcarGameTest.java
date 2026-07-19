import domain.Car;
import domain.NumberGenerator;
import domain.RacingcarGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarGameTest {

    class TestNumberGenerator implements NumberGenerator {
        private final int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

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
        RacingcarGame testGame = new RacingcarGame();
        NumberGenerator testNumberGenerator = new TestNumberGenerator(7);

        Car car1 = new Car("car1", testNumberGenerator);
        Car car2 = new Car("car2", testNumberGenerator);
        Car car3 = new Car("car3", testNumberGenerator);

        car3.move();

        testGame.addCar(car1);
        testGame.addCar(car2);
        testGame.addCar(car3);

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(car3, winnerCars.get(0));
        assertEquals(1, winnerCars.size());
    }
    @Test
    void 공동_우승자가_있을_때() {
        // Given
        RacingcarGame testGame = new RacingcarGame();
        NumberGenerator testNumberGenerator = new TestNumberGenerator(7);

        Car car1 = new Car("car1", testNumberGenerator);
        Car car2 = new Car("car2", testNumberGenerator);
        Car car3 = new Car("car3", testNumberGenerator);

        car2.move();
        car3.move();

        testGame.addCar(car1);
        testGame.addCar(car2);
        testGame.addCar(car3);

        // When
        List<Car> winnerCars = testGame.getWinner();

        // Then
        assertEquals(car2, winnerCars.get(0));
        assertEquals(car3, winnerCars.get(1));
        assertEquals(2, winnerCars.size());
    }


    /*
     * 자동차간의 이동거리 비교 테스트
     * */
    @Test
    void max값보다_더_큰_경우() {
        // Given
        RacingcarGame racingcarGame = new RacingcarGame();
        NumberGenerator testNumberGenerator = new TestNumberGenerator(7);

        int max = 0;
        Car car = new Car("testCar", testNumberGenerator);
        car.move();

        // When
        //int result = racingcarGame.maxDistance(max, car);

        // Then
        //assertEquals(1, result);
    }

    @Test
    void max값보다_작거나_같은_경우() {
        // Given
        RacingcarGame racingcarGame = new RacingcarGame();
        NumberGenerator testNumberGenerator = new TestNumberGenerator(7);

        int max = 2;
        Car car = new Car("testCar", testNumberGenerator);
        car.move();

        // When
        //int result = racingcarGame.maxDistance(max, car);

        // Then
        //assertEquals(2, result);
    }

}
