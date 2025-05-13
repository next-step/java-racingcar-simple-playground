package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int count;


    public RacingGame(List<String> carName, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("사도할 회수는 음수로 작성하면 안됩니다.");
        }

        this.cars = carName.stream()
                .map(RacingCar::new)
                .toList();
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
                .toList();
    }
}
