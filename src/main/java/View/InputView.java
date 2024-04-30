package View;

import Domain.CarList;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner=new Scanner(System.in);
    public static String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분):");
        String input= scanner.nextLine();
        String[] carNames=input.split(","); //, 단위로 끊어서 이름 배열 만들기

        return carNames;
    }

    public static int getTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int r= scanner.nextInt();   //시도 횟수 입력 받기

        return r;
    }
}
