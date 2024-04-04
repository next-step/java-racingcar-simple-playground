package car.view;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return scanner.next();
    }
    public String inputGameNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.next();
    }
}
