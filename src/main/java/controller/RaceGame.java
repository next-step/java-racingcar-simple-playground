package controller;

import objects.Car;
import objects.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceGame {
    int gameCount;

    private static Cars carRepository;

    private static List<Car> winningCars = new ArrayList<>();

    public Cars getCars(){
        return carRepository;
    }

    public  RaceGame(String[] names , int gameCount){

        this.gameCount=gameCount;

        carRepository = new Cars();

        for (int i = 0; i < names.length; i++) {
            Car myCar = new Car(names[i]);
            carRepository.getCars().add(myCar);

        }

        for (int i = 0; i < gameCount; i++) {

            carRepository.race();

        }

        carRepository.makeWinningCars();



    }

}
