package controller;

import domain.Car;
import domain.Cars;
import domain.Racing;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingController {

    private static final NumberGenerator randomGenerator = new RandomNumberGenerator();

    public void run() {

        OutputView.printInputCarNames();
        List<String> carNames = InputView.getCarNames();
        Cars cars = Cars.from(createCars(carNames));

        OutputView.printInputRoundNumber();
        int roundNumber = InputView.getRoundNumber();

        Racing racing = new Racing(cars);

        OutputView.printResult();
        playRace(racing, cars, roundNumber);

        Cars winnerList = racing.findWinners();
        OutputView.printWinners(winnerList.getCars());
    }

    public List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for(String name : names) {
            cars.add(new Car(name, randomGenerator));
        }
        return cars;
    }

    public void playRace(Racing racing, Cars cars, int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            racing.playRound();
            OutputView.printProcess(cars.getCars());
        }
    }

}
