import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> selectWinners(){
        int max = 0;
        List<Integer> winnerCarIndex = new ArrayList<>();
        for (Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        int finalMax = max;
        return cars.stream().filter(car -> car.getDistance() == finalMax).toList();
    }


    public void raceStart(int count){
        for (int i = 0; i < count; i++) {
            raceOneLap();
        }
    }

    private void raceOneLap() {
        for (Car car : cars) {
            car.moveOrStop(RandomValueGenerator.generate());
        }
    }
}
