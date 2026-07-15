package mission3;

import mission2.Racing;

import java.util.Scanner;

public class MissionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("레이싱에 참가하고자 하는 자동차의 이름을 입력하시오 : (자동차 이름은 쉼표(,)를 기준으로 분류합니다.)");
        String carName = scanner.nextLine();
        String[] carNameArr = carName.split(",");

        System.out.println("몇회 진행할 예정입니까?");
        int racingCount = scanner.nextInt();

        Racing racing = new Racing(carNameArr, racingCount);
        System.out.println("실행결과");
        racing.start();
    }
}
