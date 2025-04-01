package application;

import controller.GameController;
import domain.MovingStrategy;
import domain.NumberGenerateStrategy;
import domain.RandomMovingStrategy;
import domain.RandomNumberGenerator;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerateStrategy numberGenerator = new RandomNumberGenerator();
        MovingStrategy movingStrategy = new RandomMovingStrategy(numberGenerator);
        GameController gameController = new GameController(movingStrategy);

        gameController.start();
    }
}
