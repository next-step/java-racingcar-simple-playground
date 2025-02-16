import controller.RacingGameController;
import dto.RaceResultInfoDto;
import scanner.ScannerPool;
import view.RacingGameInputView;
import view.RacingGameResultView;

public class RacingGameApplication {

    private static final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private static final RacingGameResultView racingGameResultView = new RacingGameResultView();

    public static void main(String[] args) {
        String carNames = racingGameInputView.getCarNames();
        int gameCount = racingGameInputView.getGameCount();
        racingGameInputView.printEmptyLine();

        RacingGameController racingGameController = new RacingGameController(carNames, gameCount);
        racingGameController.race();
        RaceResultInfoDto raceResult = racingGameController.getRaceResult();

        racingGameResultView.printWinners(raceResult);

        closeResources();
    }

    private static void closeResources() {
        ScannerPool.closeAll();
    }
}
