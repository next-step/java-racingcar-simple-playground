package controller;

import domain.CarRace;
import view.OutputView;

public class CarRaceController {
    public void race(CarRace carRace) {
        for (int i = 0; i < carRace.getTryCount(); i++) {
            carRace.raceOneLap();
            OutputView.printCarsInfo(carRace.getCars());
        }

        final var winners = carRace.findWinners();
        OutputView.printWinners(winners);
    }
}
