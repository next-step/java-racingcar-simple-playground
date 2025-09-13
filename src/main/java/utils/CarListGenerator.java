package utils;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarListGenerator {

    public List<Car> generateCars(int carCount){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++){
            Car car = new Car("Car No." +  i, 0);
            cars.add(car);
        }
        return cars;
    }
}