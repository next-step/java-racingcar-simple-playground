package car.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> carList = new ArrayList<>();

    public RacingCars(List<String> carNames){
        carNames.forEach(carName -> carList.add(new Car(carName)));
    }

    public List<Car> getCarList() {
        return carList;
    }


}
