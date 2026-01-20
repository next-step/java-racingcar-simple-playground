package racingcar;

import java.util.Random;
import java.util.Scanner;
import racingcar.controller.RacingCarApplication;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        new RacingCarApplication(random, inputView, outputView).race();
    }
}
