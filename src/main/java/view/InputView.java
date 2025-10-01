package view;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static int readRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = scanner.nextInt();
        System.out.println();
        System.out.println("실행 결과");
        return rounds;
    }
}

