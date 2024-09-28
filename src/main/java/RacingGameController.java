import domain.car.Car;
import domain.car.Cars;
import domain.racegame.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void racingStart() {

        String carsNameInput = inputCarsNameFromUser();
        int raceCount = inputRaceCountFromUser();

        List<Car> carsList = createCars(carsNameInput);
        Cars cars = new Cars(carsList);

        RacingGame racingGame = new RacingGame(cars, raceCount);

        resultView.printExecutionResultsMessage();

        while (racingGame.isRaceOngoing()) {
            racingGame.playOneRoundRace();
            resultView.printRaceResult(cars);
        }

        String winners = racingGame.getWinners();
        resultView.printWinners(winners);
    }

    private String inputCarsNameFromUser() {
        while (true) {
            try {
                inputView.printCarsNameInputSentence();

                String carsNameInput = inputCarsName();
                validateCarsName(carsNameInput);

                return carsNameInput;

            } catch (IllegalArgumentException e) {
                inputView.printError(e.getMessage());
            }
        }
    }

    private int inputRaceCountFromUser() {
        while (true) {
            try {
                inputView.printRaceCountInputSentence();

                int raceCount = inputRaceCnt();
                validateRaceCount(raceCount);

                return raceCount;

            } catch (IllegalArgumentException e) {
                inputView.printError(e.getMessage());
            }
        }
    }

    private String inputCarsName() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private int inputRaceCnt() {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("레이스 횟수는 정수여야 합니다.");
        }

        int raceCount = scanner.nextInt();
        return raceCount;
    }

    private void validateCarsName(String carsNameInput) {
        String[] carNames = carsNameInput.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }

    private void validateRaceCount(int raceCount) {

        if (raceCount <= 0) {
            throw new IllegalArgumentException("레이스 횟수는 1 이상이어야 합니다.");
        }

    }

    private List<Car> createCars(String carsNameInput) {

        return Arrays.stream(carsNameInput.split(","))
                .map(Car::new)
                .toList();
    }

}