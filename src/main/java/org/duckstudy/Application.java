package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.duckstudy.controller.CarRacingController;
import org.duckstudy.model.generator.NumberGenerator;
import org.duckstudy.model.generator.RandomNumberGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class Application {

    private Application() {
    }

    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputView inputView = new InputView(bufferedReader, outputView);
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        CarRacingController carRacingController = new CarRacingController(inputView, outputView, numberGenerator);
        carRacingController.run();
    }
}
