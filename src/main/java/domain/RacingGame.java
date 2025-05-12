package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int count;

    public RacingGame(List<String> carName, int count) {
        this.cars = carName.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        this.count = count;
    }

    public void race() {
        IntStream.range(0, count)
                .forEach(i -> cars.forEach(car -> car.move(RandomNumber.numberStatus())));
    }

    public List<String> getWinner() {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}
