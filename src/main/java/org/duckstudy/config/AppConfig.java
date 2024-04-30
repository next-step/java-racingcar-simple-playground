package org.duckstudy.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.duckstudy.model.generator.RandomNumberGenerator;
import org.duckstudy.model.generator.NumberGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class AppConfig {

    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new InputView(bufferedReader, outputView());
    }

    public NumberGenerator randomValueGenerator() {
        return new RandomNumberGenerator();
    }
}
