package controller;

import model.Car;
import model.Cars;

import java.util.ArrayList;
import java.util.List;


public class CarsController {
    private Cars cars;

    public void setCars(){
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("num1");
        Car car2 = new Car("num2");
        Car car3 = new Car("num3");
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        cars = new Cars(carList);
    }

    public void getCarsWinner(){
        cars.getWinner();
    }
}
