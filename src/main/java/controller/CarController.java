package controller;

import model.Car;

public class CarController {

    private Car car;
    public void saveCar(String carName){
        car = new Car(carName);
    }

    public void carMove(){
        car.move();
    }
}