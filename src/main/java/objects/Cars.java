package objects;


import view.Output;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winningCars = new ArrayList<>();

    public void race() {

        for (Car myCar : cars) {
            myCar.move(0, 10);
            Output.carNowPosition(myCar);
        }

    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinningCars() {
        return winningCars;
    }

    public void makeWinningCars() {

        int maxPosition = -1;

        for (Car myCar : cars) {
            maxPosition = Math.max(maxPosition, myCar.getPosition());
        }

        for (Car myCar : cars) {
            myCar.samePosition(winningCars, maxPosition);
        }
    }
}
