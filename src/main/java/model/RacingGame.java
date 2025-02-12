package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int RANDOM_BOUND = 10; // 난수 범위 0-9
    private final List<Car> cars;
    private final Random random = new Random();

    public RacingGame(List<Car> carNames) {
        this.cars = carNames;
    }

    // 레이스 진행
    public void race() {
        for (Car car : cars) {
            int randomNum = random.nextInt(RANDOM_BOUND);
            car.move(randomNum);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    // 우승자 찾기
    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주에 참가한 자동차가 없습니다."));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
