package controller;

import model.Car;
import model.Cars;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Cars cars;

    public RaceController(InputView inputView, OutputView outputView, Cars cars) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = cars;
    }

    public void playRace() {
        //시도할 회수는 몇회인가요?
        int roundNumber = inputView.getRoundNumber();

        for (int i = 0; i < roundNumber; i++){
            cars.tryMovingEveryCar();
            //실행 결과
            outputView.printCurrentRaceState(cars.getRacerInfo());
        }

        //neo, brown가 최종 우승했습니다.
        outputView.printWinners(cars.getMaxDistanceCarNames());
    }

    public void addCarsFromUser() {
        List<String> names = inputView.getNamesFromUser();
        for(String name: names) {
            cars.addCar(new Car(name));
        }
    }
}
