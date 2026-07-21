package view;

import java.util.Scanner;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분, 1~10자)");
        String racingcars = sc.nextLine();
        String[] names = racingcars.split(",");

        for(int i = 0; i < names.length; i++){ // 예외처리 - 이름의 길이는 1 ~ 10으로 제한
            if(names[i].isBlank()){
                throw new IllegalArgumentException("각 이름은 1자 이상으로 입력해주세요.");
            }
            if(names[i].length() > 10){
                throw new IllegalArgumentException("각 이름은 10자 이하로 입력해주세요.");
            }
        }

        return names;
    }


    public static int getTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = sc.nextInt();

        // 예외처리 - 횟수는 1 ~ 20으로 제한
        if(count < 1 || count > 20){
            throw new IllegalArgumentException("횟수는 1회 ~ 20회 중 입력해주세요.");
        }

        System.out.println();

        return count;
    }

}
