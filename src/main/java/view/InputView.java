package view;

import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",");
        for(String name : names){
            validateName(name);
        }
        return names;
    }

    public static int getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private static void validateName(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
        }
    }

}
