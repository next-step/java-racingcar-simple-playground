import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    void moveCars() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Cars cars = new Cars(List.of(car1, car2));
        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();

        assertTrue(car1.isSamePosition(1));
        assertTrue(car2.isSamePosition(1));
    }

    @Test
    void getWinners() {
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");
        Cars cars = new Cars(List.of(winner1, winner2, loser));
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
        Cars cars = new Cars(List.of(winner1, winner2, loser));
        ArrayList<Car> expected = new ArrayList<>(List.of(winner1, winner2));
        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4, 3, 4, 4, 4));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();
        carRace.moveCars();

        assertEquals(expected, carRace.getWinners());
    }

}
