package racingCar.view;

import java.util.List;

import racingCar.domain.Car;

public class OutputView {

    private OutputView(){
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < winner.size(); i++) {
            if (i == winner.size() - 1) {
                winners.append(winner.get(i).getName());
            } else {
                winners.append(winner.get(i).getName() + ", ");
            }
        }

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
