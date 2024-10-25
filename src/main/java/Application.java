import view.InputView;
import view.ResultView;
import domain.CarRace;

public class Application {
  public static void main(String[] args) {
    final var carNames = InputView.getCarNames();
    final var tryCount = InputView.getTryCount();

    final var racingGame = new CarRace(tryCount, carNames);
    racingGame.runRace();

    ResultView.printWinners(racingGame.getWinners());
  }
}
