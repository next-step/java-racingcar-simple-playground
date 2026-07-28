package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class ResultView {
    public static void printRace(Cars cars) {
        System.out.println("실행결과");
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("%s : ", cars.get(i).getName());
            System.out.printf("%s", makePosition(cars.get(i).getPosition()));
            System.out.println();
        }
    }

    private static String makePosition(int position) {
        return "-".repeat(position);
    }

    public static void printWinner(List<Car> winner) {
        for (int i = 0; i < winner.size(); i++) {
            System.out.printf("%s ", winner.get(i).getName());
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
