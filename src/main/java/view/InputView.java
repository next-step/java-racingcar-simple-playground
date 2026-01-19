package view;

import java.util.Scanner;

public final class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine();
    }

    public int readTryCount() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = scanner.nextLine().trim();

            try {
                int tryCount = Integer.parseInt(input);
                if (tryCount < 1) {
                    System.out.println("시도 횟수는 1 이상의 정수여야 합니다.");
                    continue;
                }
                return tryCount;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
            }
        }
    }
}