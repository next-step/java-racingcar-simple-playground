package Utils;

import Model.Car;
import Model.CarName;

import java.util.ArrayList;
import java.util.List;

public class StringToCar {
    public List<Car> carList;
    public StringToCar(List<String> carNames) {
        carList= new ArrayList<>();
        carNames.forEach(car -> carList.add(new Car(new CarName(car))));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
