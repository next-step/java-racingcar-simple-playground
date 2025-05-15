import java.util.List;
import java.util.stream.Collectors;

public class CarRaceResultAnalyzer {

    public static List<Car> decideWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return carsAtPosition(cars, maxPosition);
    }

    private static int findMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private static List<Car> carsAtPosition(List<Car> cars, int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
