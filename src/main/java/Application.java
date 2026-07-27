import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {

    public static void main(String[] args) {

        String[] names = InputView.carName();
        int number = InputView.playNum();

        RacingGame racingGame = new RacingGame();
        racingGame.init(names);

        for (int i = 0; i < number; i++) {
            racingGame.play();
            ResultView.result(racingGame);
        }

        ResultView.printWinner(racingGame);
    }
}
