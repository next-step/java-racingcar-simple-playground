import controller.RacingGame;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import java.util.Scanner;
import view.InputView;
import view.ResultView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView(new Scanner(System.in));
    ResultView resultView = new ResultView();
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    RacingGame racingGame = new RacingGame(inputView, resultView, numberGenerator);
    racingGame.run();
  }
}

