package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_NAME_LENGTH = 5;

    public static List<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String[] input = scanner.nextLine().split(",");

        return Arrays.stream(input)
                .map(String::strip)
                .peek(name -> {
                    if (name.length() > MAX_NAME_LENGTH) {
                        throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
                    }
                })
                .toList();
    }

    public static int getCount() {
        System.out.print("시도할 회수는 몇 회인가요? ");
        return Integer.parseInt(scanner.nextLine());
    }
}
