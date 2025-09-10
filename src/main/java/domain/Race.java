package domain;

import utils.RandomDigitGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public int carCount;
    public int raceTurn;



    public void initRace(List<Car> cars){
        for(Car car : cars){
            car.carPosition = 0;
        }
    }








    public Race(int carCount, int raceTurn) {
        this.carCount = carCount;
        this.raceTurn = raceTurn;
    }
}
