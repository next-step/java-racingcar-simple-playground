package controller;

import model.Car;
import model.Cars;

public class CarController {

    private Car car;
    private Cars carList;
    private String[] carNames = {"붕붕이", "씽씽이", "주전차"};
    public void saveCars(){
        for(String carName: carNames){
            carList.save(new Car(carName));
        }
    }

    public void moveCars(){
        for(Car car : carList.getCars()){
            car.move();
        }
    }
}
