import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import domain.Car;
import domain.CarGame;

import java.util.List;

@DisplayName("Car Game test")
public class TestCarGame {

    @Test
    @DisplayName("assertEquals")
    void assertEqualsTest() {
        final var a = 1;
        final var b = 2;
        final var actual = a + b;

        final var expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("car move test")
    void testCarMove() {
        Car moveCar = new Car("move");
        int carDistance = moveCar.getDistance();
        moveCar.move();
        // 자동차가 움직였을 수도 있고 안 움직였을 수도 있음. 따라서 거리 증가 여부만 확인.
        assertTrue(moveCar.getDistance() == carDistance || moveCar.getDistance() == carDistance + 1);
    }

    @Test
    @DisplayName("car create test")
    void testCreateCar() {
        String[] carNames = {"createCar1", "createCar2", "createCar3"};
        List<Car> createCars = CarGame.createCar(carNames);

        assertEquals(3, createCars.size());
        assertEquals("createCar1", createCars.get(0).getName());
        assertEquals("createCar2", createCars.get(1).getName());
        assertEquals("createCar3", createCars.get(2).getName());
    }

    @Test
    @DisplayName("find max distance test")
    void testFindMaxDistance() {
        Car maxCar1 = new Car("maxCar1");
        Car maxCar2 = new Car("maxCar2");
        Car maxCar3 = new Car("maxCar3");

        // 전진할 때까지 move
        while(maxCar1.getDistance() > 0){
            maxCar1.move();
        }

        List<Car> cars = List.of(maxCar1, maxCar2, maxCar3);
        int maxDistance = CarGame.findMaxDistance(cars);

        assertEquals(maxCar1.getDistance(), maxDistance);
    }


    @Test
    @DisplayName("find winner test")
    void testFindWinner() {
        Car winnerCar1 = new Car("winnerCar1");
        Car winnerCar2 = new Car("winnerCar2");
        Car winnerCar3 = new Car("winnerCar3");

        //// winner는 winnerCar1과 winnerCar2로 설정 후 테스트
        // 전진할 때까지 move
        while(winnerCar1.getDistance() == 0){
            winnerCar1.move();
        }
        // 전진할 때까지 move
        while(winnerCar2.getDistance() == 0){
            winnerCar2.move();
        }

        List<Car> findWinnerCars = List.of(winnerCar1, winnerCar2, winnerCar3);
        int maxDistance = CarGame.findMaxDistance(findWinnerCars);
        List<String> winners = CarGame.findWinner(findWinnerCars, maxDistance);

        assertEquals(2, winners.size());
        assertEquals("winnerCar1", winners.get(0));
        assertEquals("winnerCar2", winners.get(1));
    }
}
