package CarGame2.domain.service;

import CarGame2.controller.InputHandler;
import CarGame2.view.OutputHandler;
import CarGame2.domain.model.Race;
import java.util.List;

public class GameManager {

    private final InputHandler inputHandler;
    private final Generator generator;
    private final OutputHandler outputHandler;

    public GameManager(InputHandler inputHandler, Generator generator, OutputHandler outputHandler) {
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
