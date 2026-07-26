package view;

import java.util.List;
import java.util.Scanner;

import domain.Car;

public class View {
    public String[] intro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine().split(",");
    }

    public int inputNum() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        number = scanner.nextInt();

        while (true) {
            if (number < 0) {
                System.out.println("0또는 양수를 입력해주세요");
                number = scanner.nextInt();
            } else {
                break;
            }
        }
        return number;
    }

    public void printCarPosition(List<Car> cars) {
        System.out.println("실행결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("");
    }
}
