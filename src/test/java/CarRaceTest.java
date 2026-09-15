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
        ArrayList<Car> cars = new ArrayList<>(List.of(winner1, winner2, loser));
        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4, 3));
        CarRace carRace = new CarRace(cars, 1, fixedNum);

        carRace.race();

        ArrayList<Car> expected = new ArrayList<>(List.of(winner1, winner2));

        assertEquals(expected, carRace.getWinners());
    }

    @Test
    void getWinnersTwoRounds() {
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");
        ArrayList<Car> cars = new ArrayList<>(List.of(winner1, winner2, loser));
        ArrayList<Car> expected = new ArrayList<>(List.of(winner1, winner2));
        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4, 3, 4, 4, 4));
        CarRace carRace = new CarRace(cars, 2, fixedNum);

        carRace.race();

        assertEquals(expected, carRace.getWinners());
    }

}
