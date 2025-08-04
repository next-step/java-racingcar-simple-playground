public class GameController {
    private final RacingGame game;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(RacingGame game, InputView inputView, OutputView outputView){
        this.game = game;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        String[] carNames = inputView.inputCarName().split(",");
        int runCount = inputView.inputRunCount();

        game.initializeGame(carNames, runCount);
        outputView.printGameStart();

        for (int i = 0; i < game.getRunCount(); ++i) {
            game.playRound();
            outputView.printRound(game.getRacingCars());
        }

        outputView.printWinner(game.findWinners());
    }
}
