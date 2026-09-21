import java.util.Scanner;

import controller.RacingController;

import domain.NumberGenerator;
import domain.RandomNumberGenerator;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingController racingController = new RacingController(inputView, outputView, numberGenerator);

        racingController.run();
    }
}
