package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.Scanner;

public class InputView {
    //스캐너 불러오기
    Scanner scanner = new Scanner(System.in);
    //<메소드>
    //자동차이름 문자열 입력받기
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    //시도할 횟수 입력받기
    public int askAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    //실행결과 출력 시작 선언
    public void startPrintOutput() {
        System.out.println("실행 결과");
    }

    //한 바퀴 돌 때마다 출력
    public void PrintMoveTurnAround(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
    }

    //스캐너 닫기
    public void closeScanner() {
        scanner.close();
    }
}