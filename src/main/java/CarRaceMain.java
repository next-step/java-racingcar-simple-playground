import domain.Race;
import numberGenerator.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class CarRaceMain {
    public static void main(String[] args) {
        final String carNames = InputView.getCarNames();
        final int count = InputView.getTryCount();

        final Race race = new Race(carNames, count);
        race.start(new RandomNumberGenerator());

        ResultView.printWinners(race.getWinners());
    }
}
