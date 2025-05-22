package view;

import domain.RoundParser;
import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        //횟수를 입력받고 유효한지 확인 후 적절하면 저장한다.
        return RoundParser.parseRound(sc.nextLine());
    }

}
