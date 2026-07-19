import domain.NumberGenerator;
import domain.RacingcarGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {
    private RacingcarGame racingcarGame;
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

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
        racingcarGame.setMoveCount(moveCount);

        playGame();
    }

    public void playGame() {
        System.out.println("\n실행결과");

        for (int i = 0; i < racingcarGame.getMoveCount(); i++) {
            racingcarGame.addDistance();
            ResultView.printCarDistance(racingcarGame.getCars());
        }
        ResultView.printWinners(racingcarGame.getWinner());
        }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
