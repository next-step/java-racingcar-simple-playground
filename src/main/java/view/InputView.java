package view;

import java.util.Scanner;

public class InputView {
    private String carNames;
    private int tryCnt;
    Scanner scanner;

    public String getCarNames() {
        scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.carNames = scanner.nextLine();
        nameException(carNames);
        scanner.close();

        return this.carNames;
    }

    public int getTryCnt() {
        scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");
        this.tryCnt = scanner.nextInt();

        scanner.close();

        return this.tryCnt;
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
