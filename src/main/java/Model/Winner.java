package Model;

import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final List<String> winnerList = new ArrayList<>();;

    public static List<String> findWinner(List<Car> carList) {
        int maxCount = findMaxCount(carList);
        carList.stream()
                .filter(car -> car.isWinner(maxCount))
                .forEach(x -> winnerList.add(x.carName.name));
        return winnerList;
    }

    public static int findMaxCount(List<Car> carList) {
        return carList.stream()
                .map(car -> car.position)
                .reduce(Integer::max)
                .orElse(0);
    }

}
