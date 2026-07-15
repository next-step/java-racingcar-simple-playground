import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarGameTest {
    @Test
    void 공동_우승자가_없을_때() {
        //Given(준비)
        RacingcarGame testGame = new RacingcarGame();
        Car car1 = new Car("car1"); Car car2 = new Car("car2"); Car car3 = new Car("car3");
        car1.move(3); car2.move(2); car3.move(5);
        testGame.addCar(car1); testGame.addCar(car2); testGame.addCar(car3);

        //When(실행)
        ArrayList<Car> carList = testGame.getWinner();

        //Then(검증)
        Car car = carList.get(0);
        assertEquals(car3, car);
    }
    @Test
    void 공동_우승자가_있을_때() {
        //Given(준비)
        RacingcarGame testGame = new RacingcarGame();
        Car car1 = new Car("car1"); Car car2 = new Car("car2"); Car car3 = new Car("car3");
        car1.move(3); car2.move(5); car3.move(7);
        testGame.addCar(car1); testGame.addCar(car2); testGame.addCar(car3);

        //When(실행)
        ArrayList<Car> winnerCarsList = testGame.getWinner();

        //Then(검증)
        Car winner1 = winnerCarsList.get(0);
        assertEquals(car2, winner1);
        Car winner2 = winnerCarsList.get(1);
        assertEquals(car3, winner2);
    }
}