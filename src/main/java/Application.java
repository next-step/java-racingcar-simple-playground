import domain.NumberGenerator;
import domain.RacingcarGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private RacingcarGame racingcarGame;

    public void run() {
        String[] names;

        while (true) {
            try {
                names = InputView.inputCarNames();
                racingcarGame = new RacingcarGame(names, randomNumberGenerator);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int moveCount = InputView.inputMoveCount();
        racingcarGame.setTotalRound(moveCount);

        playGame();
    }

    private void playGame() {
        System.out.println("\n실행결과");

        while (!racingcarGame.isFinished()) {
            racingcarGame.playRound();
            ResultView.printCarDistance(racingcarGame.getCars());
        }

        ResultView.printWinners(racingcarGame.getWinner());
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
