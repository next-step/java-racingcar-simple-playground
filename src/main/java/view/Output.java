package view;

import objects.Car;
import objects.Cars;

import java.util.ArrayList;
import java.util.List;

public class Output {

    private List<Car> winningCars ;

    public Output(Cars cars){
        winningCars=cars.getWinningCars();
    }

    public void winner() {

        String winnerName = "";

        if (winningCars.size() == 1) {
            winnerName += winningCars.get(0).getName();
            System.out.println(winnerName + "가 최종 우승했습니다.");
            return;
        }

        for (int i = 0; i < winningCars.size() - 1; i++) {
            winnerName += winningCars.get(i).getName();
            winnerName += ", ";
        }

        int carsSize = winningCars.size();
        winnerName += winningCars.get(carsSize - 1).getName();
        System.out.println(winnerName + "가 최종 우승했습니다.");
        return;

    }

}
