import domain.NumberGenerator;
import domain.RacingcarGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {
    private RacingcarGame racingcarGame;
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    /*
    * 리펙터링: RacingCarGame에서 Application으로 이동(UI)
    * */
    public void run() {
        String[] nameArr;

        while (true) {
            try {
                nameArr = InputView.inputCarNames();
                racingcarGame = new RacingcarGame(nameArr, randomNumberGenerator);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int moveCount = InputView.inputMoveCount();
        racingcarGame.setMoveCount(moveCount);

        playGame(); // 게임 실행
    }

    /*
     * moveCount 만큼 게임을 실행
     * 리펙터링: RacingCarGame에서 Application으로 이동(UI)
     * */
    public void playGame() {
        System.out.println("\n실행결과");

        for (int i = 0; i < racingcarGame.getMoveCount(); i++) {
            racingcarGame.addDistance();
            ResultView.printCarDistance(racingcarGame.getCarList());
        }
        ResultView.printWinners(racingcarGame.getWinner());
        }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
