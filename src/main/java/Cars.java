import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private CarMovement carMovement;

    public Cars(List<String> names, CarMovement carMovement) {
        this.cars = new ArrayList<>();
        this.carMovement = carMovement;

        for (String name : names) {
            cars.add(new Car(name, 0));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    private void moveIfPossible(Car car) {
        int number = carMovement.generate();
        if(Car.isMovable(number)) {
            car.move();
        }
    }

    public int findMaximum() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> filterByPosition(int target) {
        return cars.stream()
                .filter(car ->car.isSamePosition(target))
                .collect(Collectors.toList());
    }
}