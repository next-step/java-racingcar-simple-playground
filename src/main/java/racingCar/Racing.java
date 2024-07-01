package racingCar;

import java.util.List;

import racingCar.domain.Car;
import racingCar.domain.CarFactory;
import racingCar.numberGenerator.NumberGenerator;
import racingCar.numberGenerator.RandomNumberGenerator;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class Racing {
    public final List<Car> cars;
    public final CarFactory carFactory;

    public Racing(String inputCars) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        this.carFactory = new CarFactory(inputCars, numberGenerator);
        this.cars = carFactory.makeCars();
    }

    public void startRacing() {
        int trial = InputView.getTrials();

        for (int i = 0; i < trial; i++) {
            moveCars();
            OutputView.printResult(cars);
        }
    }

    public List<Car> getWinner() {
        return carFactory.getWinner();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
