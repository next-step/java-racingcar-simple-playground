package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final Cars cars;
    private final int totalRounds;
    private int currentRound;
    private final MoveStrategy moveStrategy;

    public Race(Cars cars, int totalRounds, MoveStrategy moveStrategy) {
        if (totalRounds <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
        this.moveStrategy = moveStrategy;
    }

    public boolean hasMoreRounds() {
        return currentRound < totalRounds;
    }

    public void playRound() {
        if (!hasMoreRounds()) {
            throw new IllegalStateException("[ERROR] 이미 모든 라운드가 종료되었습니다.");
        }

        for (Car car : cars.getCarList()) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
        currentRound++;
    }

    public List<String> getWinners() {
        int maxPosition = cars.getCarList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.getCarList().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
