package view;

import domain.Car;

import java.util.ArrayList;

public class Print {

    public void printRacing(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.printf("%s : %s\n", carList.get(i).name, printLine(carList.get(i).getCurrentLocation()));
        }

        System.out.println();
    }

    public String printLine(int currentLocation) {
        StringBuilder line = new StringBuilder("-");
        for (int i = 0; i < currentLocation; i++) {
            line.append("-");
        }

        return line.toString();
    }

    public void printWinners(ArrayList<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");

    }

    public void printResultHeader() {
        System.out.println("\n실행 결과");
    }
}
