package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameWinner {
    public int getMaxLocation(RacingGame racingGame) {
        int maxLocation = 0;
        for (Car car : racingGame.getRacingCars()) {
            if (car.getLocation() >= maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    public List<Car> selectWinners(RacingGame racingGame) {
        List<Car> winners = new ArrayList<>();
        int maxLocation = getMaxLocation(racingGame);
        for (Car car : racingGame.getRacingCars()) {
            if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
