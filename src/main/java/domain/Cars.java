package domain;

import java.util.*;

//자동차 목록을 관리
public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        Set<String> nonDuplicateMembers = new HashSet<>();
        for (Car car : cars) {
            nonDuplicateMembers.add(car.getName());
        }
        if (nonDuplicateMembers.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복 될 수 없습니다.");
        }
    }

    public List<Car> getWinner() {
        List<Car> winner = new ArrayList<>();
        int maxNum = findMaxNum(cars);
        for (Car car : cars) {
            findWinner(maxNum, car, winner);
        }
        return winner;
    }

    private void findWinner(int maxNum, Car car, List<Car> winner) {
        if (car.getPosition() == maxNum) {
            winner.add(car);
        }
    }

    private int findMaxNum(List<Car> cars) {
        int carNum = cars.size();
        int[] scores = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            scores[i] = cars.get(i).getPosition();
        }
        Arrays.sort(scores);
        return scores[scores.length - 1];
    }

    public int size() {
        return cars.size();
    }

    public Car get(int i) {
        return cars.get(i);
    }

    public void racingCars(NumberGenerator numberGenerator) {
        for (int i = 0; i < cars.size(); i++) {
            int number = numberGenerator.generate();
            cars.get(i).move(number);
        }
    }
}
