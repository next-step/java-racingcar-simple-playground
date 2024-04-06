import java.util.ArrayList;

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
        for (Car car : cars) {
            if (car.distance == M) {
                winCars.add(car);
            }
        }
        return winCars;
    }
}
