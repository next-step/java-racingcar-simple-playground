package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        String[] splits = null;
        boolean splitsCheck = false;
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                splits = scanner.nextLine().split(",", -1);

                // 예외가 발생할 수 있는 검증 메서드를 호출
                splitsCheck = isValid(splits);
            } catch (IllegalArgumentException e) {
                // validateCarNames에서 예외를 던지면 이 코드가 실행됨
                // 예외에 담긴 메시지를 출력하고, while 루프의 처음으로 돌아감
                System.out.println(e.getMessage());
            }
            if (splits != null && splitsCheck) return splits;
        }
    }

    private static String[] getStrings(String[] splitCar) {
        if (isValid(splitCar)) {
            return splitCar;
        }
        return null;
    }

    public static int getRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거
        return count;
    }

    public static boolean isValid(String[] cars) {
        if (cars.length <= 1) {
            // boolean을 반환하는 대신, 예외를 생성하고 던집니다.
            throw new IllegalArgumentException("[ERROR] 두 개 이상의 자동차를 입력해주세요!");
        }

        for (String car : cars) {
            if (car.trim().isEmpty()) {
                System.out.println("자동차의 이름이 공백일 순 없습니다!");
                return false;
            }
        }
        return true;
    }
}
