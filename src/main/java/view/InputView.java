package view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String[] carName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String name = scanner.nextLine();
        return name.split(",");
    }

    public static int playNum() {
        System.out.println("\n시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}




