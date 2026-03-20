package controller;

import model.Cars;
import model.CarsWinner;
import model.Number.IsMovable;
import view.OutputView;

public class RacingService {
    public void startRace(Cars cars, int raceCount) {
        IsMovable isMovable = new IsMovable();
        CarsWinner carsWinner = new CarsWinner();

        for (int i = 0; i < raceCount; i++) {
            cars.moveAll(isMovable); // Model의 상태 변경 요청
            OutputView.printRoundResult(cars.getCars()); // View에 출력 요청
        }
        carsWinner.findWinners(cars);
    }
}
