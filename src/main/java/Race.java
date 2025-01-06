import java.util.ArrayList;
import java.util.List;

public class Race {
    public List<Car> cars = new ArrayList<>();

    public void makeCar(int n) {
        for(int i = 0; i < n ; i++){
            cars.add(new Car("Car"+(i + 1)));
        }
    }

    public void moveCar(int n){
        for(int i = 0; i < n ; i++){
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.distance > maxDistance) {
                maxDistance = car.distance;
            }
        }

        for (Car car : cars) {
            if (car.distance == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }
}
