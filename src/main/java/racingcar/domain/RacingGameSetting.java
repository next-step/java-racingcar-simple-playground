package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSetting {
    private List<Car> carList;  //경기에 참여하는 차
    private int moveTimes;  //랩 횟수
    private int carCount;   //경기에 참여하는 차 갯수

    public RacingGameSetting(int numberOfCars, int moveTimes) {
        carList = new ArrayList<>(numberOfCars);
        this.moveTimes = moveTimes;
        this.carCount = numberOfCars;
    }

    public void addCar(String carName) {
        carList.add(new Car(carName));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMoveTimes() {
        return moveTimes;
    }
}
