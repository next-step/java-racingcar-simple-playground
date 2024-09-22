import domain.RaceGame;
import domain.RandomValueRule;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {

        String[] carNames = InputView.getCarsName();
        int tryCount = InputView.getTryCount();

        final RaceGame raceGame = new RaceGame(carNames, tryCount, new RandomValueRule());

        raceGame.start();


        ResultView.printWinners(raceGame.getWinners());
    }
}
