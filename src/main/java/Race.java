import java.util.ArrayList;
import java.util.List;

public class Race {
    public List<Car> cars = new ArrayList<>();

    public void makeCar(String[] carNames) {
        for(int i = 0; i < carNames.length ; i++){
            cars.add(new Car(carNames[i]));
        }
    }

    public void moveCar(int n){
        for(int i = 0; i < n ; i++){
            for (Car car : cars) {
                car.move();
            }
            printRace();
            System.out.println();
        }
    }

    public void printRace() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.distance; j++) {
                System.out.print("-");
            }
            System.out.println();
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
