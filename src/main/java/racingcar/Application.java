package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //사용자 입력 받기 (쉼표로 구분해서 자동차 이름 입력)
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        List<String> carNames = List.of(value.split(","));  // comma로 쪼개서 carNames에 문자열 형태로 차 이름들을 받는다

        int carCount = carNames.size(); //총 몇대의 차가 경주에 참여하는지 carCount

        //사용자 입력 받기 (시도 횟수 정수로 입력)
        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        System.out.println(); //출력 형식에 맞추기 위한 줄바꿈

        Racing racing = new Racing(carCount, number);

        //차 개수만큼 객체를 만들어서 Racing의 carList라는  arrayList에 넣어야한다.. 그래서 Racing 클래스에 addCar를 추가로 만들었다
        // 단, 각 객체의 이름은 carNames에 있는 이름으로 초기화한다.
        for (int i = 0; i < carCount; i++) {
            racing.addCar(carNames.get(i));
        }

        System.out.println("실행 결과");
        racing.startRacing();

        scanner.close();
    }
}
