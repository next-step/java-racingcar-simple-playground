package domain;


import java.util.ArrayList;
import java.util.List;
import utils.RaceUtils;

public class Race {
    public int carCount;
    public int raceTurn;

    private RaceUtils raceUtils = new RaceUtils();


    public void initRace(List<Car> cars){
        for(Car car : cars){
            car.carPosition = 0;
        }
    }

    public List<Car> playRace(List<Car> cars , int raceTurn){
        initRace(cars);
        for(int i=0;i<raceTurn;i++){
            raceUtils.playSingleTurn(cars);
        }
        return raceUtils.getWinner(cars);
    }



    public Race(int carCount, int raceTurn) {
        this.carCount = carCount;
        this.raceTurn = raceTurn;
    }
}