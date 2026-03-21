package racingcar.view;

import racingcar.model.NumberGenerator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String readInput() { // 자동차들의 이름 입력 기능
        return scanner.nextLine();
    }

    public int readTryCount() { // 게임 반복 횟수 입력 기능
        return scanner.nextInt();
    }

    public String retryReadCarNames() {
        return scanner.nextLine();
    }
}
