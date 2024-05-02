package car.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();
    private String winnerNames;

    public RacingCars(List<String> carNames){
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setWinner(String winnerNames){
        this.winnerNames = winnerNames;
    }
    public String getWinner (){
        return winnerNames;
    }
}
