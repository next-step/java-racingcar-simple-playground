package view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] names = sc.nextLine().split(",");

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }

        return names;
    }

    public static int inputMoveCount() {
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                int moveCount = sc.nextInt();

                if (moveCount <= 0) {
                    throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
                }

                return moveCount;

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
