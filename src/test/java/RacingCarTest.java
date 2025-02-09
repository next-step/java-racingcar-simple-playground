import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;


public class RacingCarTest {

    @Test
    void testCarCreat() {
        RacingCar car = new RacingCar("BMW");
        assertEquals("BMW", car.getName());
        assertEquals(0, car.getSpace());
    }
    @Test
    void testMovement() {
        RacingCar car = new RacingCar("Tesla");
        int initialSpace = car.getSpace();

        for (int i = 0; i < 20; i++) {
            car.move();
        }
        assertTrue(car.getSpace() > initialSpace);
    }

    @Test
    void testRandomValueRange() {
        RacingCar car = new RacingCar("Hyun");
        for (int i = 0; i < 100; i++){
            int randomValue = car.GetRandom();
            assertTrue(randomValue >= 0 && randomValue < 10, "랜덤 값이 범위를 벗어남.");
        }
    }

    @Test
    void testValidCarName() {
        String[] validNames = {"a", "b", "c"};
        assertDoesNotThrow(() -> RacingCar.validdateCarNames(validNames));
    }

    @Test
    void testInvalidNameExceptionIsWork() {
        String[] invalidNames = {"aaaaaa" ,"bbbbbb", "cccccc"};
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> { RacingCar.validdateCarNames(invalidNames);
        });
        assertTrue(exception.getMessage().contains("5글자를 초과할 수 없다."));
    }

    @Test
    void testFindWinner() {
        RacingCar car1 = new RacingCar("a");
        RacingCar car2 = new RacingCar("b");

        car1.move();
        car1.move();
        car1.move();
        List<RacingCar> cars = List.of(car1, car2);
        List<RacingCar> winner = RacingCar.findWinners(cars);
        assertEquals("a", winner.get(0).getName());
    }
    @Test
    void testMultipleWinners() {
        RacingCar car1 = new RacingCar("a");
        RacingCar car2 = new RacingCar("b");

        car1.move();
        car2.move();

        List<RacingCar> cars = List.of(car1,car2);
        List<RacingCar> winners = RacingCar.findWinners(cars);
        assertTrue(winners.contains(car1));
        assertTrue(winners.contains(car2));
    }
}


