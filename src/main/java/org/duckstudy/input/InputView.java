package org.duckstudy.input;

import java.io.BufferedReader;
import java.io.IOException;
import org.duckstudy.output.OutputView;

public class InputView {

    private final BufferedReader bufferedReader;
    private final OutputView outputView;

    public InputView(BufferedReader bufferedReader, OutputView outputView) {
        this.bufferedReader = bufferedReader;
        this.outputView = outputView;
    }

    public String[] inputCarNames() throws IOException {
        outputView.printInputCarNamesMessage();
        return bufferedReader.readLine().split(",");
    }

    public int inputRepetitionNum() throws IOException {
        outputView.printInputRepetitionNumMessage();
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void validateInput(String[] carNames, int repetitionNum) {
        try {
            InputValidator inputValidator = new InputValidator();
            inputValidator.validateInput(repetitionNum, carNames);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
        }
    }
}
