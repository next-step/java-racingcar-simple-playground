package controller;

import domain.Car;
import domain.Race;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Race race;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.race = new Race();
    }

    public void run() {
        boolean validInput = false;
        do{
            String[] carNames = inputView.getCarNames();
            try {
                race.addCars(carNames);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류: " + e.getMessage());
                race.removeCars();
            }
        }while(!validInput);

        int rounds = inputView.getRounds();
        System.out.println("\n실행 결과");

        for (int i = 0; i < rounds; i++) {
            race.moveCars(1);
            outputView.printRaceStatus(race.getCars());
            System.out.println();
        }

        List<Car> winners = race.getWinners();
        outputView.printWinners(winners);
    }
}

