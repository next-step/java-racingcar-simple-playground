public class RacingGameApplication {

    public static void main(String[] args) throws Exception {
        RacingGame racingGame = new RacingGame();
        InputView inputView = new InputView(racingGame);
        ResultView resultView = new ResultView(racingGame);

        inputView.inputCarNames();
        int rounds = inputView.inputRaceRounds();
        resultView.printView(rounds);
    }
}
