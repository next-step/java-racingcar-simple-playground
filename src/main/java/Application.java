import domain.RacingcarGame;
import view.InputView;
import view.ResultView;

public class Application {
    RacingcarGame racingcarGame = new RacingcarGame();
    /*
    * 리펙터링: RacingCarGame에서 Application으로 이동(UI)
    * */
    public void run() {
        String[] nameArr;

        while (true) {
            try {
                racingcarGame.clearCarList();

                nameArr = InputView.inputCarNames();

                racingcarGame.putNamesToList(nameArr); // Car 객체를 생성하며 이름 길이 검증, 오류 발생시 재입력 요구

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        int moveCount = InputView.inputMoveCount(); // 이동 횟수 입력
        racingcarGame.setMoveCount(moveCount);

        playGame(); // 게임 실행
    }

    /*
     * moveCount 만큼 게임을 실행
     * 리펙터링: RacingCarGame에서 Application으로 이동(UI)
     * */
    public void playGame() {
        System.out.println("\n실행결과");

        for (int i = 0; i < racingcarGame.getMoveCount(); i++) { // moveCount만큼 반복
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
