package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getDistance()));
            System.out.println();
        }
    }

    public void printWinners(List<Car> winners) {
        System.out.print("\n최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i).getName());
        }
        System.out.println();
    }
}
