package org.duckstudy.view;

import java.io.BufferedReader;
import java.io.IOException;

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
}
