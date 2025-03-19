package controller;

import domain.Car;
import domain.Cars;
import domain.NumberGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class CarRunner {

  private final InputView inputView;
  private final OutputView outputView;
  private final NumberGenerator numberGenerator;
  private static final int MIN_ATTEMPTS = 1;
  private static final int MIN_CAR_COUNT = 2;

  public CarRunner(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.numberGenerator = numberGenerator;
  }


  public void run() {
    List<String> carNames = inputView.inputCars();
    Cars cars = new Cars(carNames, numberGenerator);
    int attempts = inputView.getAttempts();
    CarRunner.validateAttempts(attempts);
    List<Car> carList = cars.getCars();
    outputView.printStart();
    for (int round = 1; round <= attempts; round++) {
      cars.moveAllCars();
      outputView.printRound(carList);
    }

    List<String> winners = cars.findWinners();
    outputView.printWinners(winners);
  }

  public static void validateAttempts(int attempts) {
    if (attempts < MIN_ATTEMPTS) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
  }

  public static void validateCarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("경주에는 최소 2대의 자동차가 필요합니다.");
    }
  }
}
