package view;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    // 자동차 입력
    public static String[] carInput(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(",");
    }

    // 게임 횟수 입력
    public static int gameNumber(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
