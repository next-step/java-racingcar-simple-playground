package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.duckstudy.controller.RacingGame;
import org.duckstudy.controller.Validator;
import org.duckstudy.generator.Generator;
import org.duckstudy.generator.RandomValueGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class GameApplication {

    private GameApplication() {
    }

    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputView inputView = new InputView(bufferedReader, outputView);
        Validator validator = new Validator(outputView);
        Generator generator = new RandomValueGenerator();

        RacingGame racingGame = new RacingGame(inputView, validator, outputView, generator);
        racingGame.run();
    }
}
