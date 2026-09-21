package view;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class InputView {
    public List<String> getCarName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        String[] names = carName.split(",");
        return Arrays.asList(names);
    }

    public int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        int  tryCount = scanner.nextInt();

        return tryCount;
    }
}
