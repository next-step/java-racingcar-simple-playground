package model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.cars = List.copyOf(cars);
        this.randomNumberGenerator = randomNumberGenerator;
    }

    // 한 라운드 동안의 레이스 진행
    public void raceSingleRound() {
        for (Car car : cars) {
            int randomNum = randomNumberGenerator.generate();
            car.move(randomNum);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    // 우승자 반환
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
