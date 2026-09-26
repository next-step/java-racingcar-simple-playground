package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    //자동차 이름 입력받기
    //static 쓰면 클래스 전체에서 공유하는거라서, 객체 생성 안하고 바로 쓸수있음
    public static String[] readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        //쉼표기준으로 잘라서 넣게끔 하는거구나 split()
        return carNames.split(",");
    }

    //자동차 생성시키기는 Cars로 옮겼음

    //시도할 횟수 받기
    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
        //nextInt()는 콘솔 입력에서 정수 하나(다음 토큰)를 읽어서 int로 반환하는 메서드임.
    }
}
