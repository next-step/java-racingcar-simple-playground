import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int MOVE_THRESHOLD = 4;
    private List<Car> cars;
    private CarMovement carMovement;

    public Race(List<String> names, CarMovement carMovement) {
        this.carMovement = carMovement;
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            int number = carMovement.generate();
            if(isMovable(number)) {
                car.move();
            }
        }
    }

    public boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    private int findMaximum() {
        int maximum = 0;
        for (Car car : cars) {
            maximum = Math.max(maximum, car.getPosition());
        }
        return maximum;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maximum = findMaximum() ;

        for (Car car : cars) {
            if (car.isSamePosition(maximum)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
