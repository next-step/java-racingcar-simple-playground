import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars){
        this.cars = cars;
    }

    public void run(RandomNumberProvider provider, Mover mover){
        for (Car car : cars) {
            car.move(provider, mover);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
