package view;

import domain.CarRace;

import java.util.Scanner;

public class InputView {

    private static final Scanner scan = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String str = scan.nextLine();
        return(str.split(","));
    }
    public static int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scan.nextInt();
    }


}
