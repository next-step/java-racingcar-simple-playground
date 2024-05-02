package domain;

import java.util.Scanner;

public class Input {

    public int timeCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public String inputNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백은 입력될 수 없습니다.");
        }
    }

    public String[] separateNames(String names) {

        return names.split(",");
    }

}
