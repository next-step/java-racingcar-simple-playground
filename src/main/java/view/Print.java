package view;

import domain.Car;

import java.util.ArrayList;

public class Print {
    public Print() {
    }

    public void printRacing(String carName, int currentLoation) {
        System.out.printf("%s : %s\n", carName, printLine(currentLoation));

    }

    public String printLine(int currentLocation) {
        StringBuilder line = new StringBuilder("-");
        for (int i = 0; i < currentLocation; i++) {
            line.append("-");
        }

        return line.toString();
    }

    public void printWinners(ArrayList<Car> winners, int i) {
        if (winners.size() == 1){
            System.out.print(winners.get(0).getName());
            System.out.println("가 최종 우승했습니다.");
            return;
        }

        if (winners.size() == i + 1) {
            System.out.print(winners.get(i).getName());
            System.out.println("가 최종 우승했습니다.");
            return;
        }

        System.out.print(winners.get(i).getName() + ", ");
    }
}
