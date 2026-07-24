package view;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        String[] names = carNames.split(",");

        for(int i = 0; i < names.length; i++ ) {
            names[i] = names[i].trim();
        }

        return Arrays.asList(names);
    }
    
    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int round = scanner.nextInt();
        System.out.println();

        return round;
    }
}
