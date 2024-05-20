package controller;

import domain.RacingGame.NumberGenerator;
import domain.RacingGame.RacingGame;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    InputView inputView;
    OutputView outputView;
    NumberGenerator numberGenerator;


    public RacingGameController(NumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = numberGenerator;
    }

    public void gameStart() {
        List<String> participantNames = getParticipantNames();
        int tryCount = getTryCount();

        RacingGame racingGame = new RacingGame(numberGenerator, participantNames);
        raceAndPrintGameStatus(racingGame, participantNames, tryCount);
        printWinner(racingGame);
    }


    private List<String> getParticipantNames() {
        while (true) {
            try {
                outputView.printNamesInputGuide();
                return inputView.getParticipantNames();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private int getTryCount() {
        while (true) {
            try {
                outputView.printTryCountInputGuide();
                return inputView.getTryCount();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private void raceAndPrintGameStatus(RacingGame racingGame, List<String> participantNames, int tryCount) {
        outputView.printResultStartGuide();
        for (int count = 1; count <= tryCount; count++) {
            racingGame.race();
            getAndPrintGameStatus(racingGame, participantNames);
        }
    }

    private void getAndPrintGameStatus(RacingGame racingGame, List<String> participantNames) {
        Map<String, Integer> locationByName = racingGame.getLocationByName();
        outputView.printGameStatus(locationByName, participantNames);
    }

    private void printWinner(RacingGame racingGame) {
        List<String> winners = racingGame.getWinner();
        outputView.printGameWinners(winners);
    }

}
