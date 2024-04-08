package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<String> findWinners(List<Car> cars) {
        return findWinners(cars, maxPosition(cars));
    }

    private static int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private static List<String> findWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)){ // 변경.
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
