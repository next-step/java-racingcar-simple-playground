package racingcar.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        return List.of(value.split(","));
    }

    public static int setTryCount() {
        int number = 0;
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            number = scanner.nextInt();//1회 미만일경우 예외처리, Integer가 아닐경우 예외처리
            if (number < 1){
                throw new IllegalArgumentException("횟수는 1회 이상으로 입력해주세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println("횟수는 정수로 입력해주세요.");
            scanner.next();
        }

        System.out.println(); // 출력 형식에 맞추기 위한 줄바꿈
        return number;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
