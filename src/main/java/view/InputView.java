package view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public ArrayList<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        String[] namesArray = value.split(",");
        ArrayList<String> names = new ArrayList<>();
        for (String name : namesArray) {
            names.add(name.trim());
        }
        return names;
    }

    public int getGameNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}