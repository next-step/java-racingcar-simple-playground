package view;

import java.util.Scanner;

public class InputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    private static String getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static String[] splitCarNames(String inputValue) {
        return inputValue.split(",");
    }

    public static String[] getCarNames() throws Exception {
        String inputValue = getUserInput();
        String[] carsName = splitCarNames(inputValue);

        validateName(carsName);
        return carsName;
    }

    private static void validateName(String[] carsName) throws Exception {
        for (String carName : carsName) {
            validateInput(carName);
        }
    }

    public static void validateInput(String carName) throws Exception {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new Exception("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야합니다.");
        }
    }

    public static int getRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = scanner.nextInt();
        System.out.println();
        return rounds;
    }
}
