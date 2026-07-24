package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameWinner {
    public int getMaxLocation(RacingGameSetting racingGameSetting) {
        int maxLocation = 0;
        for (Car car : racingGameSetting.getCarList()) {
            if (car.getLocation() >= maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    public List<Car> selectWinners(RacingGameSetting racingGameSetting) {
        List<Car> winners = new ArrayList<>();
        int maxLocation = getMaxLocation(racingGameSetting);
        for (Car car : racingGameSetting.getCarList()) {
            if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
