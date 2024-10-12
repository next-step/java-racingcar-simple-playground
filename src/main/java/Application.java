import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String namesText = RacingGameHost.getCarNames(sc);
    int round = RacingGameHost.getCount(sc);

    RacingGame game = new RacingGame(namesText, round);

    RacingGameHost.playGame(game);

    RacingGameHost.projectWinners(game);
  }
}
