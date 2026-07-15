import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    void moveCars(){
        for (Car car : cars){
            car.move();
        }
    }
}
