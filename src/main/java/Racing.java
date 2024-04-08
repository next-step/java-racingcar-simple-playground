import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Car> winCars = new ArrayList<>();

    /**
     * n개의 자동차가 t번 moving
     */
    public void racing(int n, int t, ArrayList<String> names) {
        int i;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (i = 0; i < n; i++) {
            Car car = new Car(names.get(i), 0, randomNumberGenerator);
            cars.add(car);
        }
        for (i = 0; i < t; i++) {
            eachRacing();
            print();
        }
    }

    /**
     * 각각의 차들 움직여주기
     */
    private void eachRacing() {
        for (Car car : cars) {
            car.moving();
        }
    }

    public ArrayList<Car> winner() {
        int M = 0;
        for (Car car : cars) {
            M = Math.max(M, car.distance);
        }
        Stream<Car> stream = cars.stream();
        int finalM = M;
        winCars.addAll(stream.filter(car -> car.distance == finalM).toList());
        return winCars;
    }

    private void print() {
        for (Car car : cars) {
            System.out.print(car.name + " : ");
            for (int i = 0; i < car.distance; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
