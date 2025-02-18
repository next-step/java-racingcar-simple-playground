package view;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");

        // 5글자 이하만 필터링 후 리턴
        return Arrays.stream(carNames)
                .filter(name -> name.length() <= 5)
                .toArray(String[]::new);
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }
}
