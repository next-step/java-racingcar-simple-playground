package view;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputView {

    private static final int MAX_NAME_LENGTH = 10;
    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 20;

    static Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분, 1~10자)");
        String racingcars = scanner.nextLine();

        String[] names = racingcars.split(",");

        for(int i = 0; i < names.length; i++){ // 공백 처리
            names[i] = names[i].trim();
        }

        for(int i = 0; i < names.length; i++){ // 자동차 이름 중복 처리
            for(int j = i + 1; j < names.length; j++){
                if(names[i].equals(names[j])){
                    throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
                }
            }
        }

        for(int i = 0; i < names.length; i++){ // 예외처리 - 이름의 길이는 1 ~ 10으로 제한
            if(names[i].isBlank()){
                throw new IllegalArgumentException("각 이름은 1자 이상으로 입력해주세요.");
            }
            if(names[i].length() > MAX_NAME_LENGTH){
                throw new IllegalArgumentException("각 이름은 10자 이하로 입력해주세요.");
            }
        }

        return names;
    }


    public static int getTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int count = scanner.nextInt();

            // 예외처리 - 횟수는 1 ~ 20으로 제한
            if (count < MIN_TRY_COUNT || count > MAX_TRY_COUNT) {
                throw new IllegalArgumentException("횟수는 1회 ~ 20회 중 입력해주세요.");
            }
            return count;
        }
        // 예외처리 - 정수가 아닌 값 처리
        catch (InputMismatchException e){
            throw new InputMismatchException("시도 횟수는 정수로 입력해주세요.");
        }
    }

}
