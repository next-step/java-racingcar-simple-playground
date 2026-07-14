package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public List<String> readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String value = sc.nextLine();

        return Arrays.stream(value.split(","))
                .map(String::trim)
                .toList();
    }

    public int readTryCount(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String value = sc.nextLine();

        return Integer.parseInt(value);
    }
}
