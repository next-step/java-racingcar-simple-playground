import java.util.List;
import java.util.ArrayList;

public class Cars {
    private List<Car> cars;
    private CarMovement carMovement;

    public Cars(List<String> names, CarMovement movement) {
        this.carMovement = movement;
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(carMovement.isMovable());
        }
    }
}