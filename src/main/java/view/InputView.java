package view;

import domain.CarName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);


    static public List<CarName> getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] names =  sc.nextLine().split(",");

        List<CarName> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(CarName.stringToName(name));
        }

        return carNames;

    }

    static public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
