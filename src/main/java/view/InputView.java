package view;
import util.InputValidation;

import java.util.Scanner;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return InputValidation.validateCarNames(in.nextLine());
    }

    public int inputRunCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return InputValidation.validateRunCount(in.nextLine());
    }
}
