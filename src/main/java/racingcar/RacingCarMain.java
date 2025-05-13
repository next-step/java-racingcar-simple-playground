package racingcar;

import racingcar.controller.RacingController;
import racingcar.ui.InputView;
import racingcar.util.DefaultRandomNumberGenerator;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new DefaultRandomNumberGenerator());

        racingController.playGame();
    }
}
