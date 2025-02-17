package model;

import java.util.List;

public class RacingGame {

    private static final String CAR_STATUS_SEPARATOR = " : "; // 자동차 상태 구분자 설정
    private static final String DASH = "-"; // 자동차 이동 위치 기호 설정

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    // 한 라운드 진행
    public void raceSingleRound() {
        for (Car car : cars) {
            int randomNum = randomNumberGenerator.generate();
            car.move(randomNum);
        }
    }

    // 자동차 상태 출력
    public List<String> getRaceStatus() {
        return cars.stream()
                .map(car -> car.getCars() + CAR_STATUS_SEPARATOR + DASH.repeat(car.getPosition()))
                .toList();
    }

    // 우승자 출력
    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주에 참가한 자동차가 없습니다."));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCars)
                .toList();
    }

    //자동차 목록 반환
    public List<Car> getCars() {
        return cars;
    }
}
