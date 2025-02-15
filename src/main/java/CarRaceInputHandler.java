import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRaceInputHandler {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static List<String> getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();

        if (value.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 반드시 입력해주세요.");
        }

        List<String> carNames = Arrays.stream(value.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 올바르게 입력해주세요.");
        }

        if (carNames.stream().anyMatch(name -> name.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
        }

        return carNames;
    }

    public static int getRaceAttemptCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

}
