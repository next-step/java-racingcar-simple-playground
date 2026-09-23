package view;

import domain.CarName;
import domain.TryCount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarName() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                String carName = scanner.nextLine();
                String[] names = carName.split(",");

                validateNames(names);

                return Arrays.asList(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateNames(String[] names) {
        for (String name : names) {
            new CarName(name);
        }
    }

    public TryCount getTryCount() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = scanner.nextLine();
                return new TryCount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}