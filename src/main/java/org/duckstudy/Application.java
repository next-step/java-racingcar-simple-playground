package org.duckstudy;

import java.io.IOException;
import org.duckstudy.controller.CarRacingController;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class Application {
    private Application() {
    }

    public static void main(String[] args) throws IOException {
        AppConfig appConfig = new AppConfig();
        OutputView outputView = appConfig.outputView();
        InputView inputView = appConfig.inputView();
        RandomValueGenerator randomValueGenerator = appConfig.randomValueGenerator();

        CarRacingController carRacingController = new CarRacingController(inputView, outputView, randomValueGenerator);
        carRacingController.run();
    }
}
