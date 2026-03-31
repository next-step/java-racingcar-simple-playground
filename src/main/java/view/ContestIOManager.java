package view;

import domain.Car;

import java.util.List;

public class ContestIOManager {

    private void printStatus(Car car) {
        System.out.println("-".repeat(car.getPosition()));
    }

    public void printResult(List<Car> participants) {
        for (Car participant : participants) {
            String name = participant.getName();
            System.out.print(name + " : ");
            printStatus(participant);
        }
        System.out.println();
    }

    public void printStart() {
        System.out.println("실행 결과");
    }

}
