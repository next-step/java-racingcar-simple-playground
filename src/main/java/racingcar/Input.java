package racingcar;

import java.util.List;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public List<String> inputName() {
        String fullName = scanner.nextLine();
        List<String> names = List.of(fullName.split(","));

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
            }
        }

        return names;
    }

    public int inputTimes() {
        return scanner.nextInt();
    }
}
