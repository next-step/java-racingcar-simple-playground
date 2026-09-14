import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    @Test
    void getWinners() {
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");
        FixedNumGenerator fixedNum3 = new FixedNumGenerator(3);
        FixedNumGenerator fixedNum4 = new FixedNumGenerator(4);
        winner1.moveCar(fixedNum4);
        winner2.moveCar(fixedNum4);
        loser.moveCar(fixedNum3);
        ArrayList<Car> cars = new ArrayList<>(List.of(winner1, winner2, loser));

        CarRace carRace = new CarRace(cars, 1);
        ArrayList<Car> expected = new ArrayList<>(List.of(winner1, winner2));

        assertEquals(expected, carRace.getWinners());
    }

}
