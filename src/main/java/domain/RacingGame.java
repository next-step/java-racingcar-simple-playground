package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void playRound() {
        List<Integer> numbers = makeNumbers();
        moveCars(numbers);
    }

    private List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < cars.size(); i++) {
            numbers.add(random.nextInt(10));
        }

        return numbers;
    }

    public void moveCars(List<Integer> numbers) {
        if(cars.size() != numbers.size()) {
            throw new IllegalArgumentException("자동차 수와 숫자의 개수가 같아야 합니다.");
        }

        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int number = numbers.get(i);

            car.move(number);
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for(Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
