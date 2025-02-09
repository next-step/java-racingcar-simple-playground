import java.util.List;
import java.util.stream.Collectors;

import util.RandomNumberProvider;

public class Game {

    private final CarGroup carGroup;
    private final int round;

    public Game(List<String> carNames, int round) {
        validateRoundIsPositive(round);
        this.carGroup = new CarGroup(createCars(carNames), new RandomNumberProvider());
        this.round = round;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void validateRoundIsPositive(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("라운드는 1 이상이어야 합니다.");
        }
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            carGroup.moveCars();
        }
    }

    public List<Car> getWinners() {
        return carGroup.getFarthestCars();
    }
}
