package view;

import java.util.Scanner;

public class InputView {
    public static String getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        return value;
    }

    public static int getTrynumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        int number = scanner.nextInt();
        return number;
    }
}
