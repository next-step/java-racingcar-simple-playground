package model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public void save(Car car){
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
