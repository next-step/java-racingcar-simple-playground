package domain;

import java.util.List;
import utils.ValueGenerator;
import view.GamePrinter;

public class CarRace {

    private List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    public void raceStart(int count, ValueGenerator generator){
        for (int i = 0; i < count; i++) {
            raceOneLap(generator);
            cars.forEach(car -> GamePrinter.printCarResult(car.getName(),car.getDistance()));
            System.out.println();
        }
    }

    private void raceOneLap(ValueGenerator generator) {
        for (Car car : cars) {
            car.moveOrStop(generator.generate());
        }
    }

    public List<String> selectWinners(){
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        int finalMax = max;
        return cars.stream()
                .filter(car -> car.getDistance() == finalMax)
                .map(Car::getName)
                .toList();
    }

}
