package step4.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int getRaceCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return validateRaceCount(scanner.nextLine());
    }

    private static int validateRaceCount(String raceCount) throws NumberFormatException {
        try {
            return Integer.parseInt(raceCount);
        }catch (Exception e){
            throw new NumberFormatException("시도할 횟수는 정수가 입력되아야 합니다.");
        }
    }


}
