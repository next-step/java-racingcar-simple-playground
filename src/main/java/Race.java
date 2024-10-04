import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int count;
    private List<String> winner;

    public List<String> getWinner() {
        return winner;
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
        winner = findWinner(cars);
    }

    public static Race createRace(List<Car> cars, int count) {
        return new Race(cars, count);
    }

    private static List<String> findWinner(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winner = new ArrayList<>();

        for(Car car : cars) {
            if (car.getLocation() == maxLocation) winner.add(car.getName());
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
