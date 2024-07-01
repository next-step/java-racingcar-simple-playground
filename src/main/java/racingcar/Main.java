package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

public class Main {
    public static void main(String[] args) {
        new GameController(new InputView()).run();
    }
}
