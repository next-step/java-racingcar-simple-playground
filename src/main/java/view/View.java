package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;

public class View {
    private int number;

    public String[] intro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine().split(",");
    }

    public int inputNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printRacingResult() {
        System.out.println("실행결과");

    }

    public int getNum() {
        return number;
    }

    public void setNum(int num) {
        this.number = num;
    }
}
