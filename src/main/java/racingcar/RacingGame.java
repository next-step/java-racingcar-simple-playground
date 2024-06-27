package racingcar;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.view.ResultView;

public class RacingGame {

    private final CarGroup carGroup;
    private final int tryCount;
    private final RandomNumberGenerator numberGenerator = new CarRandomNumberGenerator();

    public static RacingGame create(String input, int tryCount) {
        String[] carNames = input.split(",");
        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();
        return new RacingGame(cars, tryCount);
    }

    private RacingGame(List<Car> carGroup, int tryCount) {
        this.carGroup = new CarGroup(carGroup);
        this.tryCount = tryCount;
    }

    public void race() {
        ResultView.printInit();
        for (int i = 0; i < tryCount; i++) {
            carGroup.move(numberGenerator);
            ResultView.printMovement(carGroup.cars());
        }
    }

    public List<Car> getWinners() {
        return carGroup.getWinners();
    }
}
