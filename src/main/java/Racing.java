import java.util.List;

public class Racing {

    public void racing(final List<Car> cars, final int executionsCount) {
        for (int i = 0; i < executionsCount; i++) {
            racingCars(cars);
        }
    }

    private void racingCars(final List<Car> cars) {
        for (Car currentCar : cars) {
            currentCar.ride();
        }
    }
}
