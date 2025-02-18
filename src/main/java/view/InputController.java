package view;

import util.NameParser;
import util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputController {
    Scanner sc = new Scanner(System.in);
    NameParser nameParser = new NameParser();
    Validation validation = new Validation();
    String strNames;
    String strTimes;
    int times;
    List<String> nameList = new ArrayList<>();

    public List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        strNames = sc.nextLine();

        nameList = nameParser.parseName(strNames);

        try {
            nameList.forEach(
                    (name) -> validation.validName(name)
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return nameList;
    }

    public int inputTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        strTimes = sc.nextLine();

        try {
            validation.validTimes(strTimes);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        times = Integer.parseInt(strTimes);

        return times;
    }
}
