import controller.GameController;
import domain.CarManager;
import domain.Game;
import domain.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        CarManager carManager = new CarManager(new RandomGenerator());
        Game game = new Game(carManager);
        GameController gameController = new GameController(game);

        gameController.createCars();
        gameController.gameStart();
        gameController.findWinner();
    }
}
