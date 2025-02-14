package model;

import java.util.Random;

public class RacingGame {

    private static final int RANDOM_BOUND = 10; // 난수 범위 0-9
    private final Cars cars;
    private final Random random = new Random();

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    // 레이스 진행
    public void race() {
        for (Car car : cars.getCars()) {
            int randomNum = random.nextInt(RANDOM_BOUND);
            car.move(randomNum);
        }
    }
}
