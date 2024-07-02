package view;

import java.util.List;

import domain.Car;

public class ResultView {

    public static void printResult(List<Car> carList){
        for (Car car : carList){
            String position = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winnerList){
        StringBuilder winners = new StringBuilder();
        for (Car car : winnerList){
            winners.append(car.getName());
            if (winnerList.indexOf(car) != winnerList.size()-1){
                winners.append(", ");
            }
        }

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
