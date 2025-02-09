public class GameController {
    private final RacingGame game;
    private final GameView view;

    public GameController(RacingGame game, GameView view){
        this.game = game;
        this.view = view;
    }

    public void startGame() {
        String[] carNames = view.inputCarName().split(",");
        int runCount = view.inputRunCount();

        game.initializeGame(carNames, runCount);
        view.printGameStart();

        for (int i = 0; i < game.getRunCount(); ++i) {
            game.playRound();
            view.printRound(game.getRacingCars());
        }

        view.printWinner(game.findWinners());
    }
}
