package car.view;

import car.domain.Car;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> getCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = sc.nextLine();
            List<String> names = List.of(input.split(","));

            new Car(names); // 임시로 Cars 객체를 생성하여 이름 규칙 검증
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
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
