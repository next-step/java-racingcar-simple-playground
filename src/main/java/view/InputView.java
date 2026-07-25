package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        String[] carName = value.split(",");
        for (int i = 0; i < carName.length; i++) {
            carName[i] = carName[i].trim();
        }
        carNameLengthCheck(carName);
        return carName;
    }

    public static void carNameLengthCheck(String[] carName) {
        for (int i = 0; i < carName.length; i++) {
            if (carName[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        if (number < 1 || number >= 1000) {
            throw new IllegalArgumentException("시도 횟수는 1이상 999 이하만 가능합니다.");
        }
        return number;
    }
}
