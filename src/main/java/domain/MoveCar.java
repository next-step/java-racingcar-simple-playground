package domain;

import domain.Car;

public class MoveCar {

    public MoveCar() {
    }

    public int getRandNum() {
        double ran = Math.random();
        return (int) (ran * 10);
    }

    public int check(int num, Car car) {
        if (num >= 4) {
            return forwardCar(car);
        }
        return stopCar(car);
    }

    public int forwardCar(Car car) {
        car.setCurrentLocation(car.getCurrentLocation() + 1);
        return car.getCurrentLocation();
    }

    public int stopCar(Car car) {
        return car.getCurrentLocation();
    }
}
