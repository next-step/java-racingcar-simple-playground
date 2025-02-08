import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RacingGame game = new RacingGame(new Random());
        GameView view = new GameView();
        GameController controller = new GameController(game, view);
        controller.startGame();
    }
}

