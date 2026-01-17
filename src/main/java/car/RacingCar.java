package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private final Random random = new Random();

    private final Cars cars;
    private final int tryCount;

    public RacingCar(List<String> names, int tryCount) {
        validateTryCount(tryCount);
        this.cars = new Cars(names);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) { // else를 쓰지 않는 원칙 준수
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            playOneRound();
            printRoundResult();
        }
        printWinners();
    }

    private void playOneRound() {
        List<Integer> randomValues = generateRandomValues(cars.getCars().size());
        cars.moveAllCars(randomValues);
    }

    private void printRoundResult() {
        for (MovingCar car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    private void printWinners() {
        List<MovingCar> winners = cars.findWinners();
        List<String> winnerNames = new ArrayList<>();
        for (MovingCar winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println("최종 우승자: " + String.join(", ", winnerNames));
    }

    private List<Integer> generateRandomValues(int count) {
        List<Integer> randomValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomValues.add(random.nextInt(10));
        }
        return randomValues;
    }



}
