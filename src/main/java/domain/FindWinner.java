package domain;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    private List<Car> cars = new ArrayList<>();
    private int longestPosition = 0;
    private List<String> winnerNames = new ArrayList<>();

    public FindWinner(List<Car> cars) {
        this.cars = cars;
    }

    public void startRacing(int count) {
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                int randomNumber = (int) (Math.random() * 10);
                car.move(randomNumber);
                System.out.println(car.getName() + " : ");
                for (int j = 0; j < car.getPosition(); j++) {
                    System.out.println("-");
                }
            }
            System.out.println("\n");
        }
    }

    public int FindLongestPosition() {
        for (Car car : cars) {
            if (car.getPosition() >= longestPosition) {
                longestPosition = car.getPosition();
            }
        }
        return longestPosition;
    }

    public List<String> FindWinnerName() {
        for (Car car : cars) {
            if (car.getPosition() == longestPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
