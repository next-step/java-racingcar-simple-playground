package view;

import utils.Utils;

import java.util.List;

public class InputHandler {

    private static final String CAR_NAMES_DELIMITER = ",";

    public List<String> getCarNames() {
        OutputView.printCarNamesInputMessage();
        String carNames = InputView.getString();

        try {
            InputValidator.validateCarNames(carNames);
            List<String> carNameList = Utils.splitByDelimiter(carNames, CAR_NAMES_DELIMITER);
            InputValidator.validateCarNameLength(carNameList);
            return carNameList;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCarNames();
        }
    }

    public int getTryCount() {
        OutputView.printTryCountInputMessage();
        int tryCount = InputView.getInt();

        try {
            InputValidator.validateTryCount(tryCount);
            return tryCount;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTryCount();
        }
    }
}
