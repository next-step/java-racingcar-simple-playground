package controller;

import domain.*;
import dto.CarDto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        try {
            runGame();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void runGame() {
        String[] names = inputView.readCarNames();
        Cars cars = Cars.from(names);

        int input = inputView.readRaceCount();
        RaceCount raceCount = new RaceCount(input);

        RacingGame racingGame = new RacingGame(cars, numberGenerator);

        runRaceAndPrintResults(raceCount, racingGame, cars);

        List<String> winnerNames = getWinnerNames(cars.findWinners());
        outputView.printWinners(winnerNames);
    }

    private void runRaceAndPrintResults(
            RaceCount raceCount,
            RacingGame racingGame,
            Cars cars
    ) {
        outputView.printResultHeader();
        for (int i = 0; i < raceCount.getValue(); i++) {
            racingGame.race();
            List<CarDto> carDtos = createCarDtos(cars);
            outputView.printCars(carDtos);
        }
    }

    private List<CarDto> createCarDtos(Cars cars) {
        List<CarDto> carDtos = new ArrayList<>();

        for (Car car : cars.iterateCars()) {
            carDtos.add(new CarDto(
                    car.getName(),
                    car.getPosition()
            ));
        }

        return carDtos;
    }

    private List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        for (Car car : winners) {
            winnerNames.add(car.getName());
        }

        return winnerNames;
    }
}
