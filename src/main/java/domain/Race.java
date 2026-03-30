package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static domain.Utils.*;

public class Race {
    private final List<Car> cars;

    public Race(final String... names) {
        cars = new ArrayList<>();
        for (final String name : names) {
            cars.add(new Car(name));
        }
        checkRedundancy(cars.toArray());
    }

    public void raceCars(final int moveCount, final int[]... arrayOfCarMoveNumbers) {
        checkSizeOf2DArray(arrayOfCarMoveNumbers, cars.size(), moveCount);
        for(int i = 0; i < cars.size(); i++) {
            cars.get(i).moveIfGreaterThan(arrayOfCarMoveNumbers[i]);
        }
    }

    public List<String> getWinners(final List<List<Integer>> moveHistories) {
        final List<String> winners = new ArrayList<>();
        final int[] movedDistance = new int[moveHistories.size()];
        for (int i = 0; i < moveHistories.size(); i++) {
            movedDistance[i] = moveHistories.get(i).stream().reduce(0, Integer::sum);
        }
        final int maxDistance = Arrays.stream(movedDistance).max().orElseThrow(NoSuchElementException::new);
        for (int i = 0; i < moveHistories.size(); i++) {
            conditionalAdd(winners, movedDistance[i] == maxDistance, cars.get(i).getName());
        }
        return winners;
    }

    public String[] getCarNames() {
        final List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames.toArray(String[]::new);
    }

    public List<List<Integer>> getMoveHistories() {
        final List<List<Integer>> moveHistory = new ArrayList<>();
        for (Car car : cars) {
            moveHistory.add(car.getMoveHistory());
        }
        return moveHistory;
    }
}
