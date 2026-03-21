package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String readInput() { // 자동차들의 이름 입력 기능
        return scanner.nextLine();
    }
}
