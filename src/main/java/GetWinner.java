import java.util.ArrayList;
import java.util.List;

public class GetWinner {

    public List<Car> decideWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return carsAtPosition(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = updateMax(max, car.getPosition());
        }
        return max;
    }

    private int updateMax(int currentMax, int candidate) {
        if (candidate > currentMax) {
            return candidate;
        }
        return currentMax;
    }

    private List<Car> carsAtPosition(List<Car> cars, int position) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                result.add(car);
            }
        }
        return result;
    }
}
