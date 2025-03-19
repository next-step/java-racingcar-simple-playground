package CarGame2;

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
        try {
            List<String> carNames = inputHandler.getCarNames();
            int rounds = inputHandler.getRounds();
            Race race = new Race(carNames, rounds, generator, outputHandler);
            playGame(race);
        } catch (Exception e) {
            System.out.println("시스템 오류가 발생했습니다. 다시 시도해주세요.");
        }
    }

    private void playGame(Race race) {
        for (int i = 1; i <= race.getRounds(); i++) {
            outputHandler.printRoundStart(i);
            race.playRound();
            race.printRaceStatus(outputHandler);
        }
        outputHandler.printWinners(race.getWinners());
    }
}
