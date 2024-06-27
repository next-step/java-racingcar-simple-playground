package racingcar;

import racingcar.view.InputView;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController(new InputView());
        controller.play();
    }
}
