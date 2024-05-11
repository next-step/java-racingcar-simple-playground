package racingcar.view;

import java.util.Scanner;

public class InputView {

    static Scanner scan = new Scanner(System.in);
    public static String[] getUserCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carList = scan.nextLine();
        return carList.split(",");
    }

    public static int getUserRaceNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        int raceNum = scan.nextInt();
        return raceNum;
    }
}
