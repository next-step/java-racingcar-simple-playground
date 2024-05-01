package view;

import objects.Car;
import objects.Cars;


import java.util.ArrayList;
import java.util.List;

public class Output {

    private final List<Car> winningCars;

    public Output(Cars cars) {
        winningCars = cars.getWinningCars();
    }

    public static void carNowPosition(Car myCar) {

        String carPosition = myCar.getPositionToString();
        System.out.println(myCar.getName() + " : " + carPosition);
        System.out.println();
    }

    public void winner() {

        StringBuilder winnerName = new StringBuilder();

        if (winningCars.size() == 1) {
            winnerName.append(winningCars.get(0).getName());
            System.out.println(winnerName.toString() + "가 최종 우승했습니다.");
            return;
        }

        for (int i = 0; i < winningCars.size() - 1; i++) {
            winnerName.append(winningCars.get(i).getName());
            winnerName.append(", ");
        }

        int carsSize = winningCars.size();
        winnerName.append(winningCars.get(carsSize - 1).getName());

        System.out.println(winnerName.toString() + "가 최종 우승했습니다.");
    }
}
