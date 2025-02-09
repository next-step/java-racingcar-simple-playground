package model;

import model.dto.RacingPlayResponse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private final Random rand;

    public Racing(Random rand) {
        this.rand = rand;
    }

    public RacingPlayResponse play(String inputCarNames, int raceCount) {
        List<String> carNames = Arrays.stream(inputCarNames.split(",")).toList();
        Cars cars = new Cars(rand, carNames);
        List<Map<String, Integer>> moveData = runRacing(raceCount, cars);

        return new RacingPlayResponse(moveData, getWinners(cars));
    }

    private List<Map<String, Integer>> runRacing(int raceCount, Cars cars) {
        List<Map<String, Integer>> moveData = new ArrayList<>();
        moveData.add(getSnapshot(cars));
        IntStream.range(0, raceCount)
                .forEach(i -> moveData.add(moveAndGetSnapshot(cars)));

        return moveData;
    }

    private Map<String, Integer> moveAndGetSnapshot(Cars cars) {
        cars.allMove();

        return getSnapshot(cars);
    }

    private Map<String, Integer> getSnapshot(Cars cars) {
        return cars.getCars().stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    private List<Car> getWinners(Cars cars) {
        int maxDistance = cars.findMaxDistance();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxDistance)
                .toList();
    }
}
