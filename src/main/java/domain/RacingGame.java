package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        this.tryCount = tryCount;
    }

    public void playGame() {
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            System.out.println();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getNames() + " : " + car.getPosition()); //위치 출력
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getNames());
            }
        }
        return winners;
    }

    public int getMaxPosition() { //가장 멀리간 것 찾기
        int maxPosition = 0;
        for (Car car : cars) {
            int currentPosition = car.getPosition();
            maxPosition = Math.max(maxPosition, currentPosition);
        }
        return maxPosition;
    }

}