import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int count;
    private List<Car> winners;

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        return winners;
    }

    private Race(List<Car> cars, int count) {
        validateRaceCreation(cars, count);

        this.cars = cars;
        this.count = count;
    }

    public void start() {
        for(int i = 0; i < count; i++) {
            cars.forEach(Car::move);
        }
        winners = findWinners(cars);
    }

    public static Race createRace(List<Car> cars, int count) {
        return new Race(cars, count);
    }

    private static List<Car> findWinners(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);
        List<Car> winner = new ArrayList<>();

        for(Car car : cars) {
            if (car.getLocation() == maxLocation) winner.add(car);
        }

        return winner;
    }

    private static int findMaxLocation(List<Car> cars) {
        int maxLocation = 0;

        for(Car car : cars) {
            int location = car.getLocation();

            if (location > maxLocation) maxLocation = location;
        }

        return maxLocation;
    }

    private static void validateRaceCreation(List<Car> cars, int count) {
        if (!isValidCarsSize(cars)) throw new IllegalArgumentException("두 대이상의 차를 입력해주세요.");
        if (!isValidCount(count)) throw new IllegalArgumentException("1번 이상의 시도횟수를 입력해주세요.");
    }

    private static boolean isValidCarsSize(List<Car> cars) {
        return cars.size() >= 2;
    }

    private static boolean isValidCount(int count) {
        return count > 0;
    }
}
