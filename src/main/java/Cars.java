import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private CarMovement carMovement;
    private Race race;

    public Cars(List<String> names, CarMovement carMovement) {
        this.cars = new ArrayList<>();
        this.carMovement = carMovement;

        for (String name : names) {
            cars.add(new Car(name, 0));
        }
    }

    //고쳐야함
    public void moveAll() {
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    private void moveIfPossible(Car car) {
        int number = carMovement.generate();
        if(Race.isMovable(number)) {
            car.move();
        }
    }

    public int findMaximum() {
        int maximum = 0;
        for (Car car : cars) {
            maximum = Math.max(maximum, car.getPosition());
        }
        return maximum;
    }

    public List<Car> filterByPosition(int maximum) {
        List<Car> filtered = new ArrayList<>();
        return cars.stream()
                .filter(car -> car.getPosition() == maximum)
                .collect(Collectors.toList());
    }
}
