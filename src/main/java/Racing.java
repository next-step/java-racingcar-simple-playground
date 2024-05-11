import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private Car[] cars;
    private int longest;

    public Car[] getCars() {
        return cars;
    }

    public Racing(Car[] cars) {
        this.cars = cars;
    }

    public void carRacing(int Test) {
        for (int i = 0; i < Test; i++) {
            eachMoving();
            Print.print(cars);
        }
    }

    private void eachMoving() {
        for (Car car : cars) {
            car.moving();
        }
    }

    private void findLongest() {
        longest = 0;
        for (Car car : cars) {
            longest = Math.max(longest, car.getDistance());
        }
    }

    public Car[] winCars() {
        ArrayList<Car> resultCars = new ArrayList<>();
        resultCars.addAll(Arrays.asList(cars));
        findLongest();
        List<Car> collect = resultCars.stream().filter(car -> car.getDistance() == longest).collect(Collectors.toList());
        Car[] result = collect.toArray(new Car[collect.size()]);
        return result;
    }
}
