import java.util.List;
import java.util.ArrayList;

public class CarList {
    private List<Car> cars;

    public CarList(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll() {
        RandomMovement randomMovement = new RandomMovement();
        for (Car car : cars) {
            car.move(randomMovement.isMovable());
        }
    }

    public int findMaximum() {
        int maximum = 0;
        for (Car car : cars) {
            maximum = Math.max(maximum, car.getPosition());
        }
        return maximum;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maximum = findMaximum();

        for (Car car : cars) {
            if(car.getPosition() == maximum){
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}