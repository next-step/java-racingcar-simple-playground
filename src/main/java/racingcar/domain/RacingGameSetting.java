package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSetting {
    private final List<Car> carList;  //경기에 참여하는 차
    private final int moveTimes;  //랩 횟수

    public RacingGameSetting(List<String> carNames, int moveTimes) {
        carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        this.moveTimes = moveTimes;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMoveTimes() {
        return moveTimes;
    }
}
