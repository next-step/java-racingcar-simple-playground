package controller;

import domain.Car;
import domain.Game;
import view.GameView;

import java.util.List;

public class GameController {

    GameView gameView = new GameView();
    Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void createCars() {
        String carNamesList = gameView.getCarNamesView();
        String[] carNames = carNamesList.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            game.addCar(car);
        }
    }

    public void gameStart() {
        int turnCount = gameView.getTurnCountView();
        game.gameStart(turnCount);
    }

    public void displayGameStatus() {
        List<List<Car>> gameHistory = game.getGameHistory();
            gameView.displayGameStatus(gameHistory);
    }

    public void findWinner() {
        List<Car> winners = game.findWinner();
        gameView.displayWinners(winners);
    }
}