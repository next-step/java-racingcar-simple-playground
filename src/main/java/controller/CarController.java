package controller;

import model.Car;
import model.Cars;

public class CarController {

    private Car car;
    private Cars carList;
    private String[] carNames = {"붕붕이", "씽씽이", "주전차"};
    public void saveCar(){
        for(String carName: carNames){
            carList.save(new Car(carName));
        }
    }
}
