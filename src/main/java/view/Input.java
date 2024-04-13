package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Input {
    //main을 사용하지 않는다
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
        //array 와 liststring?
    }

    public static int readAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}

