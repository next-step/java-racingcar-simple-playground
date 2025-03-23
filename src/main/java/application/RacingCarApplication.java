package application;

import controller.GameController;
import domain.RandomNumberGenerator;

public class RacingCarApplication {

    public static void main(String[] args) {

        final GameController gameController = new GameController();
        gameController.start();
    }
}
