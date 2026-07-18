package mission4;

import mission2.Racing;
import mission4.view.InputView;

import java.util.Scanner;

public class MissionMain {
    public static void main(String[] args) {

        final var carNameArr = InputView.getCarNames();
        final var racingCount = InputView.getTryCount();

        Racing racing = new Racing(carNameArr, racingCount);
        System.out.println("실행결과");
        racing.start();
    }
}
