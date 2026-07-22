package mission4.view;

import java.util.Scanner;

public class InputView {

    static public String[] getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("레이싱에 참가하고자 하는 자동차의 이름을 입력하시오 : (자동차 이름은 쉼표(,)를 기준으로 분류합니다.)");
        String carName = scanner.nextLine();
        return carName.split(",");
    }

    static public int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇회 진행할 예정입니까?");
        return scanner.nextInt();
    }
}
