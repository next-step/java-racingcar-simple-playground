import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String line = sc.nextLine();
        return Arrays.stream(line.split(",")).map(String::trim).toList();
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = sc.nextInt();
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
        return count;
    }
}
