package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.duckstudy.controller.CarRacingController;
import org.duckstudy.controller.Validator;
import org.duckstudy.model.generator.Generator;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class Application {

    private Application() {
    }

    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputView inputView = new InputView(bufferedReader, outputView);
        Validator validator = new Validator(outputView);
        Generator generator = new RandomValueGenerator();

        CarRacingController carRacingController = new CarRacingController(inputView, validator, outputView, generator);
        carRacingController.run();
    }
}
