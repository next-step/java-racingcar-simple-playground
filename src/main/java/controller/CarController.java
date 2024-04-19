package controller;

import domain.Car;
import domain.CarFactory;
import domain.CarRace;
import java.util.List;
import utils.CarNameParser;
import utils.ValueGenerator;
import validator.InputValidator;
import view.GamePrinter;
import view.GameReader;

public class CarController {

    public void gameRun(final ValueGenerator generator) {
        List<String> carNames = inputCarNames();
        List<Car> cars = CarFactory.createCars(carNames, generator);
        int gameCount = inputGameCount();
        gameStart(cars, gameCount, generator);
    }

    // 자동차 이름 입력받기
    private List<String> inputCarNames() {
        String carNames = GameReader.getNames();
        return CarNameParser.parseStringArray(carNames);
    }

    // 진행 횟수 입력받기
    private int inputGameCount() {
        int gameCount = GameReader.getCount();
        InputValidator.validateGameCount(gameCount);
        return gameCount;
    }

    // 경주 시작
    private void gameStart(final List<Car> cars,
                           final int gameCount,
                           final ValueGenerator generator) {
        CarRace carRace = new CarRace(cars);
        GamePrinter.printResultStart();
        for (int i = 0; i < gameCount; i++) {
            carRace.raceOneLap();
            cars.forEach(car -> GamePrinter.printCarResult(car.getName(), car.getDistance()));
            System.out.println();
        }
        List<String> winners = carRace.selectWinners();
        GamePrinter.printRaceWinners(winners);
    }

}
