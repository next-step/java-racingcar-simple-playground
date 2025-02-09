package controller;

import model.Car;
import model.Racing;
import model.dto.RacingPlayResponse;
import view.RaceOutputView;
import view.UserInputView;

import java.util.Random;

public class RaceController {

    private final RaceOutputView raceOutputView;
    private final Random random;

    public RaceController(RaceOutputView raceOutputView, Random random) {
        this.raceOutputView = raceOutputView;
        this.random = random;
    }

    public void start() {
        raceOutputView.inputCarNames();
        String carNames = UserInputView.readStringInput();
        raceOutputView.inputRaceCount();
        int raceCount = UserInputView.readIntegerInput();

        Racing racing = new Racing(random);
        RacingPlayResponse response = racing.play(carNames, raceCount);

        raceOutputView.printRacingData(response.moveData());
        raceOutputView.printWinners(response.winners()
                .stream().map(Car::getName).toList());
    }
}
