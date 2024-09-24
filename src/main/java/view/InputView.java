package view;

import java.util.*;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = sc.nextLine(); // 연속적으로 입력되는(근데 ,를 포함한) 차량 이름을 담는 String 형 carNames
        return new ArrayList<>(Arrays.asList(carNames.split(","))); // 배열의 요소를 리스트로 반환..?
    }

    public static int readAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
