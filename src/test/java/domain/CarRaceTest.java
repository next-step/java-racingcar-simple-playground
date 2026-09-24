package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import generator.FixedNumGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    void 모든_자동차가_한번씩_이동_시도() {
        Car car1 = new Car("car1", 0);
        Car car2 = new Car("car2", 0);
        Cars cars = new Cars(List.of(car1, car2));

        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 3));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();

        assertTrue(car1.isSamePosition(1));
        assertTrue(car2.isSamePosition(0));
    }

    @Test
    void 가장_멀리_이동한_자동차_우승() {
        Car winner = new Car("win", 0);
        Car loser = new Car("lose", 0);
        Cars cars = new Cars(List.of(winner, loser));

        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 3));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();

        assertEquals(List.of(winner), carRace.getWinners());
    }

    @Test
    void 가장_멀리_이동한_자동차들_공동_우승() {
        Car winner1 = new Car("win1", 0);
        Car winner2 = new Car("win2", 0);
        Car loser = new Car("loser", 0);
        Cars cars = new Cars(List.of(winner1, winner2, loser));

        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4, 3));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();

        assertEquals(List.of(winner1, winner2), carRace.getWinners());
    }

    @Test
    void 여러_라운드_진행_후_우승자_탐색() {
        Car winner1 = new Car("win1", 0);
        Car winner2 = new Car("win2", 0);
        Car loser = new Car("loser", 0);
        Cars cars = new Cars(List.of(winner1, winner2, loser));

        FixedNumGenerator fixedNum = new FixedNumGenerator(List.of(4, 4, 3, 4, 4, 4));
        CarRace carRace = new CarRace(cars, fixedNum);

        carRace.moveCars();
        carRace.moveCars();

        assertEquals(List.of(winner1, winner2), carRace.getWinners());
    }

    @Test
    void 우승자를_여러번_조회해도_같은_결과_반환() {
        Car winner = new Car("win", 1);
        Car loser = new Car("loser", 0);
        Cars cars = new Cars(List.of(winner, loser));

        CarRace carRace = new CarRace(cars, new FixedNumGenerator(List.of(4, 3)));

        List<Car> firstResult = carRace.getWinners();
        List<Car> secondResult = carRace.getWinners();

        assertEquals(firstResult, secondResult);
        assertEquals(1, secondResult.size());
    }

    @Test
    void 자동차가_없으면_경주를_생성할_수_없다() {
        Cars cars = new Cars(List.of());

        assertThrows(IllegalArgumentException.class,
                () -> new CarRace(cars, new FixedNumGenerator(List.of(4))));
    }
}
