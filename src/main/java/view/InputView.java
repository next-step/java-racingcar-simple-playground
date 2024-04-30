package view;

import java.util.Scanner;

public class InputView {

    public String getCarNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        nameException(carNames);

        return carNames;
    }

    public int getTryCnt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");

        int tryCnt = scanner.nextInt();

        return tryCnt;
    }

    public void nameException(String carNames) {
        String[] Names = carNames.split(",");
        for (int i = 0; i < Names.length; i++) {
            if (Names[i].length() > 5) {
                throw(new RuntimeException("자동차 이름은 5글자만 가능합니다."));
            }
        }
    }
}
