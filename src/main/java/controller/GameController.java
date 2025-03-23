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
        if (carNames.length == 0) {
            throw new IllegalStateException("차량을 입력하세요");
        }

        for (String carName : carNames) {
            game.addCar(Car.createCar(carName));
        }
    }

    public void gameStart() {
        int turnCount = gameView.getTurnCountView();
        if (turnCount <= 0) {
            throw new IllegalArgumentException("턴의 수는 1이상이어야 합니다.");
        }
        for (int i = 0; i <turnCount; i++) {
            game.turn();
            gameView.displayGameStatus(game.findAllCar());
        }
    }

    public void findWinner() {
        List<Car> winners = game.findWinner();
        gameView.displayWinners(winners);
    }
}