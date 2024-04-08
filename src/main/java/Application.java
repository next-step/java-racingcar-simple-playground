import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    //메인
    public static void main(final String... args) {
        final var carNames = InputView.getCarNames();//이름입력
        final var tryCount = InputView.getTryCount();//횟수입력

        final var racingGame = new RacingGame(carNames, tryCount);

        racingGame.playGame(); //경주 실행

        ResultView.printWinners(racingGame.getWinners()); //결과
    }
}
