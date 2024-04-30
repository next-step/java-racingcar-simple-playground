package org.duckstudy;

import java.io.IOException;
import org.duckstudy.config.AppConfig;
import org.duckstudy.controller.CarRacingController;
import org.duckstudy.model.generator.NumberGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class Application {

    private Application() {
    }

    public static void main(String[] args) throws IOException {
        AppConfig appConfig = new AppConfig();
        OutputView outputView = appConfig.outputView();
        InputView inputView = appConfig.inputView();
        NumberGenerator numberGenerator = appConfig.randomValueGenerator();

        CarRacingController carRacingController = new CarRacingController(inputView, outputView, numberGenerator);
        carRacingController.run();
    }
}
