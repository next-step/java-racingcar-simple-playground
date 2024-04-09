import controller.RaceController;
import view.InputView;

public class CarRacingApplication {
    public static void main(String[] args) {
        final String[] carNames = InputView.getCarNames();
        final int raceCount = InputView.getRaceCount();

        final RaceController raceController = new RaceController(carNames, raceCount);
        raceController.startRace();
        raceController.showRaceWinners();
    }
}
