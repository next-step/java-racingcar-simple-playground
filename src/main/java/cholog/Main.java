import domain.RacingContest;
import view.InputView;
import view.ResultView;


public class Main {

  public static void main(String[] args) throws Exception {
    final var playerNames = InputView.getPlayerNames();
    final var rounds = InputView.getRounds();
    final var racingContest = new RacingContest(playerNames, rounds);

    ResultView.printContest(racingContest);
  }
}
