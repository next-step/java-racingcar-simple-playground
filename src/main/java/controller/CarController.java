package controller;

import domain.Car;
import domain.CarRace;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.Parser;
import validator.InputValidator;
import view.GamePrinter;
import view.GameReader;

public class CarController {

    public void gameRun() {
        List<Car> carNames = inputCarNames();
        int gameCount = inputGameCount();
        gameStart(carNames, gameCount);
    }

    // 자동차 이름 입력받기
    private List<Car> inputCarNames() {
        String carNames = GameReader.getNames();
        List<String> parsedNames = Parser.parseStringArray(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : parsedNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    // 진행 횟수 입력받기
    private int inputGameCount() {
        int gameCount = GameReader.getCount();
        InputValidator.validateGameCount(gameCount);
        return gameCount;
    }

    // 경주 시작
    private void gameStart(List<Car> cars, int gameCount) {
        CarRace carRace = new CarRace(cars);
        GamePrinter.printResultStart();
        carRace.raceStart(
                gameCount,
                () -> {
                    Random random = new Random();
                    return random.nextInt(10);
                });
        List<String> winners = carRace.selectWinners();
        GamePrinter.printRaceWinners(winners);
    }

}
