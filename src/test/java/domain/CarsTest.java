package domain;

import objects.Car;
import objects.Cars;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    Cars cars = new Cars();

    @Test
    void 포지션_가장_높은_차가_승리한다() {

        for (int i = 0; i < 3; i++) {
            Car car = new Car("i");
            cars.getCars().add(car);
        }

        cars.getCars().get(0).initOnlyTestCar("a1", 0, 100);
        cars.getCars().get(1).initOnlyTestCar("a2", 0, 50);
        cars.getCars().get(2).initOnlyTestCar("a3", 0, 70);

        cars.makeWinningCars();

        String winnerCar = cars.getWinningCars().get(0).getName();

        assertEquals("a1", winnerCar, "[ERROR] 승리하는 자동차 함수가 잘못되었습니다.");
    }
}