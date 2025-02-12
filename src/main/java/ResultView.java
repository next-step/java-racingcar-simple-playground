public class ResultView {

    private final RacingGame racingGame;

    public ResultView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void printView(int rounds) {
        System.out.println("실행 결과");
        racingGame.gameStart(rounds);
        racingGame.getWinner();

        System.out.print(racingGame.findWinnerName());
        System.out.println("가 최종 우승했습니다.");
    }
}
