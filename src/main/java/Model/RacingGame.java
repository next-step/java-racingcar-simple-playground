package Model;

import Creator.NumberCreator;
import Model.Car;
import Model.CarName;
import Model.Winner;
import View.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList;
    NumberCreator randomNumberCreator;
    int tryCount;
    public RacingGame(List<Car> carList, int tryCount, NumberCreator randomNumberCreator) {
        this.tryCount = tryCount;
        this.carList = carList;
        this.randomNumberCreator = randomNumberCreator;
    }

    public void race() {
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(car -> car.move(randomNumberCreator.returnNumber()));
            ResultView.printResult(carList);
        }
    }


    public List<String> getWinners() {
        return Winner.findWinner(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    boolean isRightName(String name){
        return name.length() <= 5;
    }
}
