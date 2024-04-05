package controller;

import model.Car;

public class CarController {

    private Car car;
    public void saveCar(){
        String carName = "붕붕이";
        car = new Car(carName);
    }

    public void carMove(){
        car.move();
    }




}
