package car.view;

import car.domain.CarGroup;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
        throw new AssertionError("InputView는 인스턴스를 생성할 수 없습니다.");
    }

    public static CarGroup getCars() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = sc.nextLine();
            List<String> names = List.of(input.split(","));

            return CarGroup.from(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    public static int getTryCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = sc.nextLine();
            return validateCount(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getTryCount(); // 예외 발생 시 다시 처음부터 실행 (재귀)
        }
    }

    private static int validateCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
