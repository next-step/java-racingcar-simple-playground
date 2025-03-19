package view;

import domain.Car;

import java.util.List;
import java.util.Scanner;

public class GameView {

    private static final String CAR_MOVE = "-";

    Scanner scanner = new Scanner(System.in);

    public String getCarNamesView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int getTurnCountView() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void displayWinners(List<Car> cars) {
        for (int i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getName() + ", ");
        }
        System.out.print(cars.get(cars.size() - 1).getName());

        System.out.println("가 최종 우승했습니다.");
    }

    public void displayGameStatus(List<List<Car>> gameHistory) {
        System.out.println("실행 결과");
        for (List<Car> cars : gameHistory) {
            printCarsStatus(cars);
        }
    }

    private void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i <car.getDistance(); i++) {
            System.out.print(CAR_MOVE);
        }
        System.out.println();
    }


}
