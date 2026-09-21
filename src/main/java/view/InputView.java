package view;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    
    public List<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        String[] names = carName.split(",");
        return Arrays.asList(names);
    }

    public String getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = scanner.nextLine();
        return tryCount;
    }
}
