import java.util.*;
import java.util.stream.Collectors;

public class GameInput {
    private final Scanner scanner;

    public GameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int readRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
