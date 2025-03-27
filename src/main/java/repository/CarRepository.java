package repository;

import domain.Car;

import java.util.LinkedList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars = new LinkedList<>();

    public List<Car> findAll() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public int getCarNumber() {
        return cars.size();
    }

}
