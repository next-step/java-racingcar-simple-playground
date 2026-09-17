import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    void getWinners() {
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");
        ArrayList<Car> cars = new ArrayList<>(List.of(winner1, winner2, loser));
        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4, 3));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();

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
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();
        carRace.moveCars();

        assertEquals(expected, carRace.getWinners());
    }

}
