package data;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {
    private final List<CarSnapShot> carSnapShots;

    public RoundResult(List<CarSnapShot> carSnapShots) {
        this.carSnapShots = carSnapShots;
    }

    public List<CarSnapShot> getCarSnapShots() {
        return carSnapShots;
    }

    public List<String> getFormattedRoundStatesPerCar() {
        return carSnapShots.stream()
                .map(car -> car.getCarName() + " : " + "-".repeat(car.getDistance()))
                .collect(Collectors.toList());
    }
}
