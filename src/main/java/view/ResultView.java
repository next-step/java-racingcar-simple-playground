public class ResultView {

    private final RacingGameService racingGame;

    public ResultView(RacingGameService racingGame) {
        this.racingGame = racingGame;
    }

    public void printRaceResults() {
        racingGame.getWinner();

        System.out.print(racingGame.findWinnerName());
        System.out.println("가 최종 우승했습니다.");
    }

}
