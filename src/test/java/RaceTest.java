import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Race 클래스 테스트")
public class RaceTest {
    private Race race;
    private Car car1, car2, car3;

    @BeforeEach
    void setUp() {
        MoveCar moveCar = new MoveCar(new Random());
        race = new Race(moveCar);

        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        race.addCar(car1);
        race.addCar(car2);
        race.addCar(car3);
    }

    @Test
    void 우승자가_한_명인_경우_우승자_한_명만_반환한다() {
        moveCarNTimes(car1, 1);
        moveCarNTimes(car2, 2);
        moveCarNTimes(car3, 3);

        List<String> winners = race.getWinners();

        assertEquals(1, winners.size());
        assertEquals("car3", winners.get(0));
    }

    @Test
    void 우승자가_두_명_이상인_경우_모든_우승자를_반환한다() {
        moveCarNTimes(car1, 1);
        moveCarNTimes(car2, 2);
        moveCarNTimes(car3, 2);

        List<String> winners = race.getWinners();

        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0));
        assertEquals("car3", winners.get(1));
    }

    private void moveCarNTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.moveForward();
        }
    }

}
