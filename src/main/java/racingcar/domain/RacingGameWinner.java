package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameWinner {
    private List<Car> winners = new ArrayList<>();  //우승 차
    private int maxLocation = 0;    //우승 위치

    public int getMaxLocation(RacingGameSetting racingGameSetting) {
        for (Car car : racingGameSetting.getCarList()) {
            if (car.getLocation() >= maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    public List<Car> selectWinners(RacingGameSetting racingGameSetting) {
        int maxLocation = getMaxLocation(racingGameSetting);
        for (Car car : racingGameSetting.getCarList()) {
            if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
