package domain;

import java.util.List;

import static java.lang.String.format;
import static view.OutPutMessage.RESULT_DETAIL_MESSAGE;
import static view.OutPutMessage.WINNER_MESSAGE;
import static view.OutputView.printMessage;
import static view.OutputView.printRound;

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

    public static Race createRace(List<Car> cars, int count) {
        return new Race(cars, count);
    }

    public void start() {
        for(int i = 0; i < count; i++) {
            cars.forEach(Car::move);
            List<String> round = createRound(cars);
            printRound(round);
        }
        winners = findWinners(cars);

        String winnerString = createWinnerString(winners);
        printMessage(format(WINNER_MESSAGE.getMessage(), winnerString));
    }

    private static List<String> createRound(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    String name = car.getName();
                    int location = car.getLocation();
                    String locationStr = createLocationStr(location);

                    return format(RESULT_DETAIL_MESSAGE.getMessage(), name, locationStr);
                }).toList();
    }

    private static String createWinnerString(List<Car> cars) {
        return String.join(", ", cars.stream().map(Car::getName).toList());
    }

    private static String createLocationStr(int location) {
        String locationStr = "-";
        return locationStr.repeat(location);
    }

    private static List<Car> findWinners(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();
    }

    private static int findMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
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
