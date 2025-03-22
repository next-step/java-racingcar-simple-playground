package controller;

import domain.Cars;
import domain.Racing;
import domain.NumberGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingController {

    private static final int NAME_LENGTH_LIMIT = 5;

    public void run(NumberGenerator numberGenerator) {

        OutputView.printInputCarNames();
        List<String> carNames = InputView.getCarNames();
        checkCarNameLengths(carNames);
        Cars carList = Cars.create(carNames, numberGenerator);

        OutputView.printInputRoundNumber();
        int roundNumber = InputView.getRoundNumber();

        Racing racing = new Racing(carList);

        OutputView.printResult();
        playRace(racing, carList, roundNumber);

        Cars winnerList = racing.findWinners();
        OutputView.printWinners(winnerList.getCars());
    }

    public void playRace(Racing racing, Cars carList, int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            racing.playRound();
            OutputView.printProcess(carList.getCars());
        }
    }

    public void checkCarNameLengths(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException("이름의 길이는 " + NAME_LENGTH_LIMIT + "자 이하여야 합니다.");
        }
    }
}
