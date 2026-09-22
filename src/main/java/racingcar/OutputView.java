package racingcar;

import java.util.List;

public class OutputView {
    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));

        }
    }
    public void printWinner(List<Car> cars){
        String winnerName="";
        for(Car car: cars){
            winnerName=winnerName+car.getName()+",";
        }
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
