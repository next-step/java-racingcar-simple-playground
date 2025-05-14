import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars){
        this.cars = cars;
    }

    public void start(int n){
        for(int i=0; i<n; i++){
            moveCars();
        }
        List<String> winners = getWinner();
        OutputView.displayWinners(winners);
    }

    private void moveCars(){
        for(Car car : cars){
            car.tryMove();
        }
        OutputView.showCurrent(cars);
    }

    private List<String> getWinner(){
        int maxLocation = getMaxLocation(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxLocation(List<Car> cars){
        return cars.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);
    }



}
