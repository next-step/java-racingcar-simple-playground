package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;

public class InputHandler {
    private String[] carNames;
    private int number;

    public void inputHandling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        this.carNames = carNames;
        System.out.println("시도할 횟수는 몇회인가요?");
        int number = scanner.nextInt();
        this.number = number;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getNumber() {
        return number;
    }
}
