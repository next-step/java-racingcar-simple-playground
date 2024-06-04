package service;

import domain.RacingGame.NumberGenerator;
import domain.RacingGame.RacingGame;
import domain.RacingGame.TryCount;
import java.util.List;
import java.util.Map;
import javax.swing.table.TableRowSorter;
import view.InputView;
import view.OutputView;

public class RacingGameService {

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

    public TryCount getTryCount() {
        while (true) {
            try {
                outputView.printTryCountInputGuide();
                int tryCount = inputView.getTryCount();
                return new TryCount(tryCount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    public void race(RacingGame racingGame, TryCount tryCount) {
        outputView.printResultStartGuide();
        for (int count = 1; count <= tryCount.getTryCount(); count++) {
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
