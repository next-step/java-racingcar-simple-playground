package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final int tryCount;
    private final List<Car> cars = new ArrayList<>();
    private List<List<Integer>> moveData = new ArrayList<>();

    // 생성자 함수
    public Racing(String[] carNames, int count) {
        for (String name: carNames)
            addCar(name);

        tryCount = calculateTryCount(count);
    }

    // 에러 처리 : tryCount 체크
    private int calculateTryCount(int tryCount) {
        if (tryCount <= 0)
            throw new IllegalArgumentException("자연수를 입력해 주세요.");

        return tryCount;
    }

    private void addCar(String curCarName) {
        Car curCar = new Car(curCarName);
        cars.add(curCar);
    }

    public void startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.forEach(Car::moveCar);
            List<Integer> roundPositions = cars.stream()
                    .map(Car::getCarPos)
                    .collect(Collectors.toList());
            moveData.add(roundPositions);
        }
    }


    private int findMaxPos() {
        return cars.stream()
                .mapToInt(Car::getCarPos)
                .max()
                .orElseThrow(() -> new IllegalStateException("차가 없습니다."));
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getCarPos() == findMaxPos())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<String> getCarsName()
    {
        return cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getMoveData()
    {
        return moveData;
    }

    public void race() {
        startRace(tryCount);
    }
}
