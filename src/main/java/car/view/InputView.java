package car.view;

import car.domain.CarGroup;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    private static <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static CarGroup getCars() {
        return repeatUntilSuccess(() -> {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = sc.nextLine();
            List<String> names = List.of(input.split(","));
            return CarGroup.from(names);
        });
    }

    public static int getTryCount() {
        return repeatUntilSuccess(() -> {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = sc.nextLine();
            return validateCount(input);
        });
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
