package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int tryCount;
    private final MoveRule moveRule;

    public RacingGame(List<String> carNames, int tryCount) {
        this(carNames, tryCount, () -> new Random().nextInt(10) >= 4);
    }

    public RacingGame(List<String> carNames, int tryCount, MoveRule moveRule) {
        this.cars = createCars(carNames);
        this.tryCount = validateTryCountError(tryCount);
        this.moveRule = moveRule;
    }

    private int validateTryCountError(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }

    private List<RacingCar> createCars(List<String> carNames) {

        return carNames.stream()
                .map(name -> new RacingCar(name))
                .toList();
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.move(moveRule.isMovable());
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<RacingCar> getCars() {
        return new ArrayList<>(cars);
    }

    private int findMaxDistance() {
        return cars.stream()
                .map(RacingCar::getDistance)
                .reduce(0, Math::max);
    }

    public List<RacingCar> whoWin() {
        int maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }
}
