package CarGame2.controller;

import CarGame2.domain.service.NumberGenerator;
import CarGame2.domain.service.RandomNumberGenerator;
import CarGame2.view.InputHandler;
import CarGame2.view.OutputHandler;
import CarGame2.domain.model.Race;
import java.util.List;

public class GameManager {

    private final InputHandler inputHandler;
    private final NumberGenerator generator;
    private final OutputHandler outputHandler;

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        NumberGenerator generator = new RandomNumberGenerator();
        OutputHandler outputHandler = new OutputHandler();

        GameManager gameManager = new GameManager(inputHandler, generator, outputHandler);
        gameManager.setGame();
    }

    public GameManager(InputHandler inputHandler, NumberGenerator generator, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.generator = generator;
        this.outputHandler = outputHandler;
    }

    public void setGame() {
        List<String> carNames = inputHandler.getCarNames();
        int rounds = inputHandler.getRounds();
        Race race = new Race(carNames, rounds, generator);
        playGame(race);
    }

    private void playGame(Race race) {
        for (int i = 1; i <= race.getRounds(); i++) {
            outputHandler.printRoundStart(i);
            race.playRound();
            outputHandler.printRaceStatus(race.getCars());
        }
        outputHandler.printWinners(race.getWinners());
    }

}
