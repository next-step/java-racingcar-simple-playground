package service;

import domain.RacingGame.NumberGenerator;
import domain.RacingGame.RacingGame;
import java.util.List;
import java.util.Map;
import util.Errors;
import view.InputView;
import view.OutputView;

public class RacingGameService {

    private static final int MIN_VALUE_OF_TRY_COUNT = 0;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public RacingGame generateRacingGame(NumberGenerator numberGenerator) {
        while (true) {
            try {
                List<String> participantNames = getParticipantNames();
                return new RacingGame(numberGenerator, participantNames);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private List<String> getParticipantNames() {
        outputView.printNamesInputGuide();
        return inputView.getParticipantNames();
    }

    public int getTryCount() {
        while (true) {
            try {
                outputView.printTryCountInputGuide();
                int tryCount = inputView.getTryCount();
                validateRangeOfTryCount(tryCount);
                return tryCount;
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private void validateRangeOfTryCount(int input) {
        if (input < MIN_VALUE_OF_TRY_COUNT) {
            throw new IllegalArgumentException(Errors.INPUT_IS_NOT_NATURAL_NUMBER_ERROR);
        }
    }

    public void race(RacingGame racingGame, int tryCount) {
        outputView.printResultStartGuide();
        for (int count = 1; count <= tryCount; count++) {
            racingGame.race();
            printGameStatus(racingGame);
        }
    }

    private void printGameStatus(RacingGame racingGame) {
        Map<String, Integer> locationByName = racingGame.getLocationByName();
        outputView.printGameStatus(locationByName);
    }
    
    public void printWinner(RacingGame racingGame) {
        List<String> winners = racingGame.getWinner();
        outputView.printGameWinners(winners);
    }

}
