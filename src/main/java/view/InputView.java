package view;

import domain.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public List<CarName> getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] names = sc.nextLine().split(",");

//        return Arrays.stream(names).map(name-> CarName.stringToName(name)).toList();
//        return Arrays.stream(names).map(CarName::stringToName).toList();
        return Arrays.stream(names).map(CarName::from).collect(Collectors.toList());
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }
}
